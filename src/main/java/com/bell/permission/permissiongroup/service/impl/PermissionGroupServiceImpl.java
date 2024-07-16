package com.bell.permission.permissiongroup.service.impl;

import org.springframework.stereotype.Service;

import com.bell.permission.permissiongroup.dto.CreatePermissionGroupDto;
import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.permissiongroup.entity.PermissionGroupEntity;
import com.bell.permission.permissiongroup.repository.PermissionGroupRepository;
import com.bell.permission.permissiongroup.service.PermissionGroupService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionGroupServiceImpl implements PermissionGroupService {
	private final PermissionGroupRepository permissionGroupRepository;

	public void createPermissionGroup(CreatePermissionGroupDto createPermissionGroupDto) {
		PermissionGroupEntity permissionGroupEntity = PermissionGroupEntity.builder()
			.name(createPermissionGroupDto.getName())
			.serviceId(createPermissionGroupDto.getServiceId())
			.build();

		permissionGroupRepository.save(permissionGroupEntity);
	}

	public PermissionGroupDto getPermissionGroup(String permissionName, Long serviceId) {
		return permissionGroupRepository.findPermissionGroupByName(permissionName, serviceId);
	}
}
