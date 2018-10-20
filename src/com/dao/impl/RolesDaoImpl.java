package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IRolesDao;
import com.entity.TActer;
/***
 * 
 * @author Feng
 *
 */
@Repository("roleDao")
public class RolesDaoImpl extends BaseDAO implements IRolesDao{

	/**添加角色*/
	public boolean insert(TActer role){
		this.getHibernateTemplate().save(role);
		return true;
	}
	
	/**删除角色*/
	public boolean delete(TActer role){
		this.getHibernateTemplate().delete(role);
		return true;
	}
	
	/**修改角色**/
	public boolean update(TActer role){
		this.getHibernateTemplate().update(role);
		return true;
	}
	
	/**查询单个角色**/
	public TActer getRole(TActer role){
		TActer role2 = this.getHibernateTemplate().get(TActer.class, role.getActerid());
		return role2;
	}
	
	/**查询所有角色*/
	@SuppressWarnings("unchecked")
	public List<TActer> list(){
		List<TActer> list = this.getHibernateTemplate().find("from TActer ");
		return list;
		
	}
	
}
