package com.cai.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cai.domain.Patient;

public interface PatientService {
	  void save(Patient patient);
	 List<Patient> findAll(DetachedCriteria criteria);
	 List<Patient>findByName(Patient patient);
}
