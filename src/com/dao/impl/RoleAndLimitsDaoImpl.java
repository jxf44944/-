package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IRoleAndLimitsDao;
import com.entity.TMiddle;

/***
 * 角色权限中间表dao实现
 * 
 * @author Feng
 *
 */
@Repository("roleandlimitsDao")
public class RoleAndLimitsDaoImpl extends BaseDAO implements IRoleAndLimitsDao {

	
	/**新增权限
	 * 因为用户的权限有多个，
	 * 这里是一条一条记录增加进去，
	 * 所以当管理员分配权限的时候，需要多次调用此方法
	 * 
	 * */
	public boolean insert(TMiddle randl){
		this.getHibernateTemplate().save(randl);
		return true;
	}
	
	/**删除用户权限*/
	public boolean delete(TMiddle randl){
		this.getHibernateTemplate().delete(randl);
		return true;
	}
	
	/**修改**/
	public boolean update(TMiddle randl){
		this.getHibernateTemplate().update(randl);
		return true;
		
	}
	
	/**查找角色的单条权限记录**/
	public TMiddle getRoleLimits(TMiddle randl){
		
		TMiddle roleLimits = this.getHibernateTemplate().get(TMiddle.class, randl.getMiddleid());
		return roleLimits;
	}
	
	/**按条件查找所有符合条件的客户列表
	 * 当传入null值时，查找所有的记录
	 * 当传入搜索条件时，按条件查询
	 * （按客户大类查询）
	 * */
	@SuppressWarnings("unchecked")
	public List<TMiddle> list(String sql){
		List<TMiddle> list = null;
		if(sql!=null){
			list = this.getHibernateTemplate().find("from TMiddle " +sql);
		}else{
			list = this.getHibernateTemplate().find("from TMiddle ");
		}
		return list;
		
	}
}
