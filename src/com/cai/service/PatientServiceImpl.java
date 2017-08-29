package com.cai.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cai.dao.PatientDao;
import com.cai.domain.Patient;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class PatientServiceImpl implements PatientService{
	private PatientDao patientDao;

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	public PatientDao getPatientDao() {
		return patientDao;
	}
	
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(Patient patient) {
		if(patient==null)
		{
			throw new RuntimeException("注册不能为空");
		}
		patientDao.save(patient);
		System.out.println("service成功调用");
	}
	
	public List<Patient> findAll(DetachedCriteria criteria) {
		
		return patientDao.findAll(criteria);
	}
	public List<Patient> findByName(Patient patient) {
		
		return patientDao.findByName(patient);
	}

	
}
