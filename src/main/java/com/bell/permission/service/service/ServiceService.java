package com.bell.permission.service.service;

import java.util.List;

import com.bell.permission.service.dto.ServiceDto;

public interface ServiceService {
	List<ServiceDto> getServiceListByOrg(Long orgId);
	List<ServiceDto> getServiceListByOrg(List<Long> orgIdList);
}
