package com.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IHospitalDao;
import com.entity.THospital;

@SuppressWarnings("unchecked")
@Repository("hospitalDao")
public class HospitalDaoImpl extends BaseDAO implements IHospitalDao {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date d=new Date();
	/**删除供应商**/
	public boolean delete(THospital hp) {
		THospital delHospital = (THospital)this.getHibernateTemplate().load(THospital.class, hp.getId());
		this.getHibernateTemplate().delete(delHospital);
		return true;
	}
	/**查询单个供应商**/
	public THospital getAHospital(THospital hp) {
		return this.getHibernateTemplate().get(THospital.class, hp.getId());
	}
	/**增加供应商**/
	public boolean insert(THospital hp) {
		hp.setTime(formatter.format(d).toString());
		this.getHibernateTemplate().save(hp);
		return true;
	}
	/**查询供应商列表**/
	public List<THospital> list() {
		List<THospital> list = this.getHibernateTemplate().find("from THospital ");
		return list;
	}
	/**修改供应商**/
	public boolean update(THospital hp) {
		this.getHibernateTemplate().update(hp);
		return true;
	}

}
