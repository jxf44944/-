package com.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IProducterDao;
import com.entity.TProducter;

@SuppressWarnings("unchecked")
@Repository("producterDao")
public class ProducterDaoImpl extends BaseDAO implements IProducterDao {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date d=new Date();
	/**删除供应商**/
	public boolean delete(TProducter pt) {
		TProducter delProducter = (TProducter)this.getHibernateTemplate().load(TProducter.class, pt.getId());
		this.getHibernateTemplate().delete(delProducter);
		return true;
	}
	/**查询单个供应商**/
	public TProducter getAProducter(TProducter pt) {
		return this.getHibernateTemplate().get(TProducter.class, pt.getId());
	}
	/**增加供应商**/
	public boolean insert(TProducter pt) {
		pt.setTime(formatter.format(d).toString());
		this.getHibernateTemplate().save(pt);
		return true;
	}
	/**查询供应商列表**/
	public List<TProducter> list() {
		List<TProducter> list = this.getHibernateTemplate().find("from TProducter ");
		return list;
	}
	/**修改供应商**/
	public boolean update(TProducter pt) {
		this.getHibernateTemplate().update(pt);
		return true;
	}

}
