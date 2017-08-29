package com.cai.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import com.cai.domain.Doctor;
import com.cai.domain.Patient;

public interface PatientDao {
	void save(Patient patient); 
	List<Patient> findAll(DetachedCriteria criteria);
	List<Patient> findByName(Patient patient);
}
