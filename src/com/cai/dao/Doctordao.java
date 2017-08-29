package com.cai.dao;

import com.cai.domain.Doctor;

public interface Doctordao {

	void save(Doctor doctor);
	/**
	 * 根据医生登陆名字获得医生对象的方法
	 * @param loginname
	 * @return
	 */
	Doctor getByDoctorName(String loginname);

}
