package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.ILimitsDao;
import com.entity.TLimit;

/***
 * 菜单栏dao实现类
 * @author Feng
 *
 */
@Repository("limitsDao")
public class LimitsDaoImpl extends BaseDAO implements ILimitsDao{

	/**新增菜单**/
	public boolean insert(TLimit limit){
		this.getHibernateTemplate().save(limit);
		return true;
	}
	
	/**删除菜单**/
	public boolean delete(TLimit limit){
		this.getHibernateTemplate().delete(limit);
		return true;
	}
	
	/**修改菜单**/
	public boolean update(TLimit limit){
		this.getHibernateTemplate().update(limit);
		return true;
	}
	
	/**查询单个菜单信息**/
	public TLimit getMsg(TLimit limit){
		
		TLimit limits = this.getHibernateTemplate().get(TLimit.class, limit.getLimitid());
		return limits;
	}
	
	/**查询所有菜单列表*/
	@SuppressWarnings("unchecked")
	public List<TLimit> list(String sql){
		List<TLimit> list = null;
		if(sql!=null){
			list = this.getHibernateTemplate().find("from TLimit "+sql);
		}else{
	//		System.out.println("here is limitDaoImpl 50 lsit();");
			list = this.getHibernateTemplate().find("from TLimit");
		}
		return list;
	}
}
