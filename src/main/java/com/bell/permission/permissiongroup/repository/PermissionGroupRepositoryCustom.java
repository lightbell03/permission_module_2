package com.bell.permission.permissiongroup.repository;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;

public interface PermissionGroupRepositoryCustom {
	PermissionGroupDto findPermissionGroupByName(String permissionName, Long serviceId);
}
