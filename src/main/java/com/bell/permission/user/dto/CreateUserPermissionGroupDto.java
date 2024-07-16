package com.bell.permission.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserPermissionGroupDto {
	private Long userId;
	private Long serviceId;
	private Long permissionId;
}
