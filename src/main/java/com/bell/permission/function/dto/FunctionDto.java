package com.bell.permission.function.dto;

import lombok.Getter;

@Getter
public class FunctionDto {
	private Long functionId;
	private String api;
	private String keyword;

	public FunctionDto(Long functionId, String api, String keyword) {
		this.functionId = functionId;
		this.api = api;
		this.keyword = keyword;
	}
}
