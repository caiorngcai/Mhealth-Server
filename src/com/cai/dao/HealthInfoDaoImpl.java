package com.cai.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cai.domain.HealthInfo;

public class HealthInfoDaoImpl extends HibernateDaoSupport implements HealthInfoDao {

	public void save(HealthInfo healthInfo) {
		getHibernateTemplate().save(healthInfo);
	}



	public List<HealthInfo> findByLoginname(HealthInfo healthInfo) {
		List<HealthInfo> list=getHibernateTemplate().findByExample(healthInfo);
		return list;
	}

}
