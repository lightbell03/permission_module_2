package com.bell.permission.service.repository;

import java.util.List;

import com.bell.permission.service.dto.ServiceDto;

public interface ServiceRepositoryCustom {
	List<ServiceDto> findServiceListByOrgIdList(List<Long> orgIdList);

	List<ServiceDto> findServiceListByOrgId(Long orgId);
}
