package com.bell.permission.menu.service;

import java.util.List;

import com.bell.permission.menu.dto.MenuDto;

public interface MenuService {
	List<MenuDto> getMenuListByPermission(List<Long> permissionIdList, Long serviceId);
}
