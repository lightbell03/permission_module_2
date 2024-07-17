package com.bell.permission.api.dto;

import lombok.Getter;

@Getter
public class ApiDto {
	private Long id;
	private String path;
	private String method;

	public ApiDto(Long id, String path, String method) {
		this.id = id;
		this.path = path;
		this.method = method;
	}
}
