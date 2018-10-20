package com.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IMedicinefatoryDao;
import com.entity.TMedicinefatory;

@SuppressWarnings("unchecked")
@Repository("medicinefatoryDao")
public class MedicinefatoryDaoImpl extends BaseDAO implements IMedicinefatoryDao {
	/**删除药库药品**/
	public boolean delete(TMedicinefatory hp) {
		TMedicinefatory delMedicinefatory = (TMedicinefatory)this.getHibernateTemplate().load(TMedicinefatory.class, hp.getId());
		this.getHibernateTemplate().delete(delMedicinefatory);
		return true;
	}
	/**查询药库单个药品**/
	public TMedicinefatory getAMedicinefatory(TMedicinefatory hp) {
		return this.getHibernateTemplate().get(TMedicinefatory.class, hp.getId());
	}
	/**增加药库药品**/
	public boolean insert(TMedicinefatory hp) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		hp.setUpdatetime(formatter.format(d).toString());
		this.getHibernateTemplate().save(hp);
		return true;
	}
	/**查询药库药品列表**/
	public List<TMedicinefatory> list() {
		List<TMedicinefatory> list = this.getHibernateTemplate().find("from TMedicinefatory ");
		return list;
	}
	/**修改药库药品**/
	public boolean update(TMedicinefatory hp) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		hp.setUpdatetime(formatter.format(d).toString());
		this.getHibernateTemplate().update(hp);
		return true;
	}
	public TMedicinefatory getAMedicinefatory(final String hql) {
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from TMedicinefatory "+hql);
		TMedicinefatory mf= (TMedicinefatory) query.uniqueResult();
		return mf;
	}


}
