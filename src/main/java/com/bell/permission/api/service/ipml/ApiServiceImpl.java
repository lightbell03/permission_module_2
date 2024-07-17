package com.bell.permission.api.service.ipml;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bell.permission.api.dto.ApiDto;
import com.bell.permission.api.repository.ApiRepository;
import com.bell.permission.api.service.ApiService;
import com.bell.permission.api.tree.ApiTreeService;
import com.bell.permission.org.dto.OrganizationDto;
import com.bell.permission.org.service.OrganizationService;
import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.service.dto.ServiceDto;
import com.bell.permission.service.service.ServiceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {
	private final ApiRepository apiRepository;

	private final OrganizationService organizationService;
	private final ServiceService serviceService;
	private final ApiTreeService apiTreeService;

	public boolean isAccessableApiOfPermission(Long orgId, Long serviceId, String path, Set<String> permissionNameSet) {
		// apiTreeService.getApiPermissionNameList();
		return false;
	}

	public List<PermissionGroupDto> getApiPermissionGroup(String path) {

		return null;
	}
}
