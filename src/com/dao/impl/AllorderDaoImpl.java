package com.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IAllorderDao;
import com.entity.TAllorder;

@SuppressWarnings("unchecked")
@Repository("allorderDao")
public class AllorderDaoImpl extends BaseDAO implements IAllorderDao {
	/**删除出入库单**/
	public boolean delete(TAllorder hp) {
		TAllorder delAllorder = (TAllorder)this.getHibernateTemplate().load(TAllorder.class, hp.getId());
		this.getHibernateTemplate().delete(delAllorder);
		return true;
	}
	/**查询单个出入库单**/
	public TAllorder getAAllorder(TAllorder hp) {
		if(hp==null){
			return null;
		}
		if(hp.getId() ==null){
			return null;
		}
		return this.getHibernateTemplate().get(TAllorder.class, hp.getId());
	}
//	/**增加出入库单**/
//	public boolean insert(TAllorder hp) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date d=new Date();
//		hp.setTime(formatter.format(d).toString());
//		this.getHibernateTemplate().save(hp);
//		return true;
//	}
	
	/**增加出入库单**/
	public Integer insert(TAllorder hp) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		hp.setTime(formatter.format(d).toString());
		this.getHibernateTemplate().save(hp);
		return hp.getId();
	}
	/**查询出入库单列表**/
	public List<TAllorder> list() {
		List<TAllorder> list = this.getHibernateTemplate().find("from TAllorder ");
		return list;
	}
	/**修改出入库单**/
	public boolean update(TAllorder hp) {
		this.getHibernateTemplate().update(hp);
		return true;
	}

}
