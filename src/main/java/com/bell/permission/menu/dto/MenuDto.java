package com.bell.permission.menu.dto;

import lombok.Getter;

@Getter
public class MenuDto {
	private Long id;
	private Long parentId;
	private String name;
	private String page;
	private String path;

	public MenuDto(Long id, Long parentId, String name, String page, String path) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.page = page;
		this.path = path;
	}
}
