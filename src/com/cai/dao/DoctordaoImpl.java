package com.cai.dao;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cai.domain.Doctor;
import com.cai.utils.HibernateUtils;



public class DoctordaoImpl extends HibernateDaoSupport implements Doctordao {
		
	public void save(Doctor doctor) {
		getHibernateTemplate().save(doctor);
		
	}

	public Doctor getByDoctorName(final String loginname) {
		return getHibernateTemplate().execute(new HibernateCallback<Doctor>()
				{

					public Doctor doInHibernate(Session session)
							throws HibernateException {
							String hql="from Doctor where loginname=?";
							org.hibernate.Query query=session.createQuery(hql);
							query.setParameter(0,loginname);
							Doctor doctor=(Doctor)query.uniqueResult();
							return doctor;
					}
				});
	}
}
