package com.bell.permission.user.dto;

import java.util.List;

import com.bell.permission.function.dto.FunctionDto;
import com.bell.permission.menu.dto.MenuDto;
import com.bell.permission.page.dto.PageDto;

import lombok.Getter;

@Getter
public class Accessable {
	List<PageDto> pageList;
	List<FunctionDto> functionList;
	List<MenuDto> menuList;

	public Accessable(List<PageDto> pageList, List<FunctionDto> functionList, List<MenuDto> menuList) {
		this.pageList = pageList;
		this.functionList = functionList;
		this.menuList = menuList;
	}
}
