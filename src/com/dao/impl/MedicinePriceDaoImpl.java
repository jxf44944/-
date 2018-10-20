package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IMedicinePriceDao;
import com.entity.TMedpromiddle;

@SuppressWarnings("unchecked")
@Repository("medicinepriceDao")
public class MedicinePriceDaoImpl extends BaseDAO implements IMedicinePriceDao {
	/**删除药品价格**/
	public boolean delete(TMedpromiddle hp) {
		TMedpromiddle delprice = (TMedpromiddle)this.getHibernateTemplate().load(TMedpromiddle.class, hp.getId());
		this.getHibernateTemplate().delete(delprice);
		return true;
	}
	/**查询单个药品价格**/
	public TMedpromiddle getAMedicinePrice(TMedpromiddle hp) {
		return this.getHibernateTemplate().get(TMedpromiddle.class, hp.getId());
	}
	/**根据条件查询药品种类列表**/
	public List<TMedpromiddle> getMedicinePrices(final String hql){
		List<TMedpromiddle> list = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query query = session.createQuery("from TMedpromiddle "+hql);
				List list = query.list();
				return list;
			}
		});
		return list;
	}
	/**增加药品价格**/
	public boolean insert(TMedpromiddle hp) {
		this.getHibernateTemplate().save(hp);
		return true;
	}
	/**查询药品价格列表**/
	public List<TMedpromiddle> list() {
		List<TMedpromiddle> list = this.getHibernateTemplate().find("from TMedpromiddle ");
		return list;
	}
	/**修改药品价格**/
	public boolean update(TMedpromiddle hp) {
		this.getHibernateTemplate().update(hp);
		return true;
	}

}
