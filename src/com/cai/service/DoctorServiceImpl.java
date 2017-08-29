package com.cai.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cai.dao.Doctordao;
import com.cai.dao.DoctordaoImpl;
import com.cai.domain.Doctor;
import com.cai.utils.HibernateUtils;


@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class DoctorServiceImpl implements DoctorService{
	private Doctordao doctorDao;
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(Doctor doctor) {
		
		if(doctor==null)
		{
			throw new RuntimeException("注册不能为空！");
		}else{
			doctorDao.save(doctor);
		}
		}
	
	public void setDoctorDao(Doctordao doctorDao) {
		this.doctorDao = doctorDao;
	}

	public Doctor getDoctorByNamePassword(Doctor doctor) {
		//1 根据登陆名称查询登陆用户
		Doctor existDoctor= doctorDao.getByDoctorName(doctor.getLoginname());
		//2 判断用户是否存在.不存在=>抛出异常,提示用户名不存在
		if(existDoctor==null){
			throw new RuntimeException("用户名不存在!");
		}
		//3 判断用户密码是否正确=>不正确=>抛出异常,提示密码错误
		if(!existDoctor.getPassword().equals(doctor.getPassword())){
			throw new RuntimeException("密码错误!");
		}
		//4 返回查询到的用户对象
	
		return existDoctor;
	}
	
	
	
}
