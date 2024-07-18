package com.bell.permission.api.tree;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bell.permission.api.dto.ApiDto;
import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.permissiongroup.service.PermissionGroupService;

@Service
public class ApiTreeService {
	private final OrganizationStore organizationStore;

	private final PermissionGroupService permissionGroupService;

	public ApiTreeService(PermissionGroupService permissionGroupService) {
		this.organizationStore = new OrganizationStore();
		this.permissionGroupService = permissionGroupService;
	}

	public List<PermissionGroupDto> getApiPermissionNameList(Long orgId, Long serviceId, String path, String method) {
		Map<String, Set<String>> apiMethodsPermission = organizationStore.getOrgServiceApiPermission(orgId, serviceId, path);

		Set<String> permissionNameSet = apiMethodsPermission.get(method);
		return permissionGroupService.getPermissionGroup(permissionNameSet, serviceId);
	}
}
