package com.cai.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cai.domain.Doctor;
import com.cai.domain.Patient;

public class PatientDaoImpl extends HibernateDaoSupport implements PatientDao{

	public void save(Patient patient) {
		getHibernateTemplate().save(patient);
		
	}

	public List<Patient> findAll(DetachedCriteria criteria) {
		
		return (List<Patient>) getHibernateTemplate().findByCriteria(criteria);
		
	}
	public List<Patient> findByName(Patient patient) {
		 List<Patient> list=(List<Patient>) getHibernateTemplate().findByExample(patient);
		return list;
	}
	
}
