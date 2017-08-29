package com.cai.service;

import java.util.List;

import com.cai.domain.HealthInfo;

public interface HealthInfoService {
	void save(HealthInfo healthInfo);
	List<HealthInfo> findByLoginname(HealthInfo healthInfo);
}
