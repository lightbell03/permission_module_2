package com.bell.permission.page.dto;

import lombok.Getter;

@Getter
public class PageDto {
	private Long pageId;
	private String path;

	public PageDto(Long pageId, String path) {
		this.pageId = pageId;
		this.path = path;
	}
}
