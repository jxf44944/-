package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IAllorderdetailDao;
import com.entity.TAllorderdetail;

@SuppressWarnings("unchecked")
@Repository("allorderdetailDao")
public class AllorderdetailDaoImpl extends BaseDAO implements IAllorderdetailDao {
	/**删除库单药品明细**/
	public boolean delete(TAllorderdetail hp) {
		TAllorderdetail delAllorderdetail = (TAllorderdetail)this.getHibernateTemplate().load(TAllorderdetail.class, hp.getId());
		this.getHibernateTemplate().delete(delAllorderdetail);
		return true;
	}
	/**查询单个库单药品明细**/
	public TAllorderdetail getAAllorderdetail(TAllorderdetail hp) {
		return this.getHibernateTemplate().get(TAllorderdetail.class, hp.getId());
	}
	/**增加库单药品明细**/
	public boolean insert(TAllorderdetail hp) {
		this.getHibernateTemplate().save(hp);
		return true;
	}
	/**查询库单药品明细列表**/
	public List<TAllorderdetail> list() {
		List<TAllorderdetail> list = this.getHibernateTemplate().find("from TAllorderdetail ");
		return list;
	}
	/**修改库单药品明细**/
	public boolean update(TAllorderdetail hp) {
		this.getHibernateTemplate().update(hp);
		return true;
	}
	public List<TAllorderdetail> getAllorderdetails(final String hql) {
		List<TAllorderdetail> list = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query query = session.createQuery("from TAllorderdetail "+hql);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

}
