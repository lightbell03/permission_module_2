package com.bell.permission.org.dto;

import lombok.Getter;

@Getter
public class OrganizationDto {
	private Long id;
	private String name;

	public OrganizationDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
