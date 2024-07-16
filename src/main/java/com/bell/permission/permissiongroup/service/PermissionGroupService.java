package com.bell.permission.permissiongroup.service;

import com.bell.permission.permissiongroup.dto.CreatePermissionGroupDto;
import com.bell.permission.permissiongroup.dto.PermissionGroupDto;

public interface PermissionGroupService {
	String DEFAULT_PERMISSION = "ROLE_USER";

	void createPermissionGroup(CreatePermissionGroupDto createPermissionGroupDto);

	PermissionGroupDto getPermissionGroup(String permissionName, Long serviceId);
}
