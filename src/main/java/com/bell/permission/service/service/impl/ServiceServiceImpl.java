package com.bell.permission.service.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.permissiongroup.service.PermissionGroupService;
import com.bell.permission.service.dto.CreateServiceDto;
import com.bell.permission.service.entity.ServiceEntity;
import com.bell.permission.service.repository.ServiceRepository;
import com.bell.permission.service.service.ServiceService;
import com.bell.permission.service.service.dto.AddUserDto;
import com.bell.permission.user.service.UserService;
import com.bell.permission.user.dto.CreateUserPermissionGroupDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
	private final ServiceRepository serviceRepository;

	private final UserService userService;
	private final PermissionGroupService permissionGroupService;

	void createService(CreateServiceDto createServiceDto) {
		ServiceEntity serviceEntity = ServiceEntity.builder()
			.name(createServiceDto.getName())
			.build();
		serviceRepository.save(serviceEntity);
	}

	void addUser(AddUserDto addUserDto) {
		String defaultPermission = PermissionGroupService.DEFAULT_PERMISSION;
		PermissionGroupDto permissionGroup = permissionGroupService.getPermissionGroup(defaultPermission,
			addUserDto.getServiceId());

		userService.saveUserPermissionGroup(new CreateUserPermissionGroupDto(addUserDto.getUserId(),
			addUserDto.getServiceId(), permissionGroup.getId()));
	}
}
