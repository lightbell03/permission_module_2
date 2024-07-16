package com.bell.permission.permissiongroup.dto;

import lombok.Getter;

@Getter
public class PermissionGroupDto {
	private Long id;
	private String name;

	public PermissionGroupDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
