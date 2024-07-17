package com.bell.permission.menu.repository;

import java.util.List;

import com.bell.permission.menu.dto.MenuDto;

public interface MenuRepositoryCustom {
	List<MenuDto> findAllMenuList();
	List<MenuDto> findMenuListByIdList(List<Long> menuIdList);
	List<MenuDto> findMenuListHasPageByPermission(List<Long> permissionIdList, Long serviceId);
}
