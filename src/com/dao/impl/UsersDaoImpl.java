package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IUsersDao;
import com.entity.TUser;
@Repository(value="usersDao")
public class UsersDaoImpl extends BaseDAO implements IUsersDao {

	

	
	/**删除用户*/
	public boolean delete(TUser cli) {
		TUser delcli = (TUser) this.getHibernateTemplate().load(
				TUser.class, cli.getId());
		this.getHibernateTemplate().delete(delcli);
		return true;
	}

	public List<TUser> select(TUser cli) {
	
		return null;
	}

	public TUser getUsers(TUser cli) {
		return this.getHibernateTemplate()
				.get(TUser.class, cli.getId());
	}

	@SuppressWarnings("unchecked")
	public List<TUser> selectAll() {
		List<TUser> li=this.getHibernateTemplate().find("from TUser");
		return li;
	}

	
	
	/**添加用户*/
	public boolean insert(TUser user){
		this.getHibernateTemplate().save(user);
		return true;
	}
	
	
	
	
	/**修改用户**/
	public boolean update(TUser user){
		this.getHibernateTemplate().update(user);
		return true;
	}
	
	/**查询单个用户**/
	public TUser getUser(TUser user){
		TUser user2 = this.getHibernateTemplate().get(TUser.class, user.getId());
		return user2;
	}
	
	/**查询所有用户*/
	@SuppressWarnings("unchecked")
	public List<TUser> list(String sql){
		List<TUser> list = new ArrayList<TUser>();
		if(sql!=null){
			list = this.getHibernateTemplate().find("from TUser "+sql);
		}else{
			list = this.getHibernateTemplate().find("from TUser ");
		}
		
			return list;
		
	}
	
	
	
}
