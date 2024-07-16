package com.bell.permission.user.repository;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.service.dto.ServiceDto;
import java.util.List;

public interface UserRepositoryCustom {
	List<PermissionGroupDto> findUserPermissionById(Long userId, Long serviceId);

	List<ServiceDto> findUserServiceById(Long id);
}
