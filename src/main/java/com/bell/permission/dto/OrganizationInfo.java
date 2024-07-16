package com.bell.permission.dto;

import lombok.Getter;

@Getter
public class OrganizationInfo {
	private Long id;
	private String name;
	public OrganizationInfo(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
