package com.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.dao.BaseDAO;
import com.dao.IMedicineDao;
import com.entity.TMedicine;
import com.entity.TMedicinetype;

@SuppressWarnings("unchecked")
@Repository("medicineDao")
public class MedicineDaoImpl extends BaseDAO implements IMedicineDao {
	/**删除药品**/
	public boolean delete(TMedicine hp) {
		TMedicine delMedicine = (TMedicine)this.getHibernateTemplate().load(TMedicine.class, hp.getId());
		this.getHibernateTemplate().delete(delMedicine);
		return true;
	}
	/**查询单个药品**/
	public TMedicine getAMedicine(TMedicine hp) {
		return this.getHibernateTemplate().get(TMedicine.class, hp.getId());
	}
	/**根据条件查询药品种类列表**/
	public List<TMedicine> getMedicines(final String hql){
		List<TMedicine> list = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				List list = query.list();
				return list;
			}
		});
		return list;
	}
	/**增加药品**/
	public boolean insert(TMedicine hp) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		hp.setTime(formatter.format(d).toString());
		this.getHibernateTemplate().save(hp);
		return true;
	}
	/**查询药品列表**/
	public List<TMedicine> list() {
		List<TMedicine> list = this.getHibernateTemplate().find("from TMedicine ");
		return list;
	}
	/**修改药品**/
	public boolean update(TMedicine hp) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		hp.setTime(formatter.format(d).toString());
		this.getHibernateTemplate().update(hp);
		return true;
	}
	public List<TMedicine> getTongJiMedicine(final String sql) {
		final List<TMedicine> medlist=new ArrayList<TMedicine>();
		getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query query = session.createSQLQuery(sql);
				List<Object[]> meds=  query.list();
				Iterator<Object[]> iterator = meds.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					TMedicine m=new TMedicine();
					m.setId((Integer)objects[0]);
					m.setNumber((String)objects[1]);
					m.setName((String)objects[2]);
					TMedicinetype tmp=new TMedicinetype();
					tmp.setProtypeid((Integer)objects[3]);
					m.setTMedicinetype(tmp);
					m.setGuige((String)objects[4]);
					m.setDanwei((String)objects[5]);
					m.setOthername((String)objects[6]);
					m.setTime((String)objects[7]);
					
					medlist.add(m);
					iterator.remove();
				}
				return medlist;
			}
		});
		return medlist;
	}

}
