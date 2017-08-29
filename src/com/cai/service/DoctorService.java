package com.cai.service;

import com.cai.domain.Doctor;
import com.cai.utils.HibernateUtils;

public interface DoctorService {

	void save(Doctor doctor);
/**
 * 根据用户名密码寻找用户的方法
 * @param doctor
 * @return
 */
	Doctor getDoctorByNamePassword(Doctor doctor);

}
