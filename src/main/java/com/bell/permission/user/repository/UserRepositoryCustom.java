package com.bell.permission.user.repository;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;

public interface UserRepositoryCustom {
	PermissionGroupDto findUserPermissionById(Long userId, Long serviceId);
}
