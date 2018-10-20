package com.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IMedicinetypeDao;
import com.entity.TMedicinetype;

@SuppressWarnings("unchecked")
@Repository("medicinetypeDao")
public class MedicinetypeDaoImpl extends BaseDAO implements IMedicinetypeDao {
	/**删除药品品种**/
	public boolean delete(TMedicinetype hp) {
		TMedicinetype delMedicinetype = (TMedicinetype)this.getHibernateTemplate().load(TMedicinetype.class, hp.getProtypeid());
		this.getHibernateTemplate().delete(delMedicinetype);
		return true;
	}
	/**查询单个药品品种**/
	public TMedicinetype getAMedicinetype(TMedicinetype hp) {
		return this.getHibernateTemplate().get(TMedicinetype.class, hp.getProtypeid());
	}
	/**增加药品品种**/
	public boolean insert(TMedicinetype hp) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		hp.setTime(formatter.format(d).toString());
		this.getHibernateTemplate().save(hp);
		return true;
	}
	/**查询药品品种列表**/
	public List<TMedicinetype> list() {
		List<TMedicinetype> list = this.getHibernateTemplate().find("from TMedicinetype ");
		return list;
	}
	/**修改药品品种**/
	public boolean update(TMedicinetype hp) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		hp.setTime(formatter.format(d).toString());
		this.getHibernateTemplate().update(hp);
		return true;
	}

}
