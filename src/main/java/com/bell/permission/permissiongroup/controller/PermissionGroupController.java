package com.bell.permission.permissiongroup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bell.permission.permissiongroup.dto.CreatePermissionGroupDto;
import com.bell.permission.permissiongroup.service.PermissionGroupService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/{serviceId}")
@RequiredArgsConstructor
public class PermissionGroupController {
	private final PermissionGroupService permissionGroupService;

	@PostMapping("/permissions")
	public ResponseEntity<Void> createPermission(
		@PathVariable("serviceId") Long serviceId,
		@RequestBody CreatePermissionGroupDto createPermissionGroupDto
	) {
		createPermissionGroupDto.setServiceId(serviceId);
		return null;
	}
}
