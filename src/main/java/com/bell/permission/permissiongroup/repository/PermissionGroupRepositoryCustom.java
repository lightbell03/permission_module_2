package com.bell.permission.permissiongroup.repository;

import java.util.List;
import java.util.Set;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;

public interface PermissionGroupRepositoryCustom {
	PermissionGroupDto findPermissionGroupByName(String permissionName, Long serviceId);
	List<PermissionGroupDto> findPermissionGroupByName(Set<String> permissionNameSet, Long serviceId);
}
