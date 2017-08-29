package com.cai.dao;

import java.util.List;

import com.cai.domain.HealthInfo;

public interface HealthInfoDao {
	void save(HealthInfo healthInfo);
	List<HealthInfo> findByLoginname(HealthInfo healthInfo);
}
