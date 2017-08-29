package com.cai.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cai.dao.HealthInfoDao;
import com.cai.domain.HealthInfo;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class HealthInfoServiceImpl implements HealthInfoService {
	private HealthInfoDao healthInfoDao;
	public HealthInfoDao getHealthInfoDao() {
		return healthInfoDao;
	}
	public void setHealthInfoDao(HealthInfoDao healthInfoDao) {
		this.healthInfoDao = healthInfoDao;
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(HealthInfo healthInfo) {
		if(healthInfo!=null)
		{
			healthInfoDao.save(healthInfo);
		}
		
	}
	
	public List<HealthInfo> findByLoginname(HealthInfo healthInfo) {
		
		return healthInfoDao.findByLoginname(healthInfo);
	}

}
