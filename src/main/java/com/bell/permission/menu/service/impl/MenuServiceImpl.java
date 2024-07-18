package com.bell.permission.menu.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bell.permission.menu.dto.MenuDto;
import com.bell.permission.menu.repository.MenuRepository;
import com.bell.permission.menu.service.MenuService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {
	private final String MENU_PATH_SEPERATOR = "."; //.1.2.3.
	private final MenuRepository menuRepository;

	public List<MenuDto> getMenuListByPermission(List<Long> permissionIdList, Long serviceId) {
		List<MenuDto> menuList = menuRepository.findAllMenuList();
		List<MenuDto> menuListHasPage = menuRepository.findMenuListHasPageByPermission(permissionIdList, serviceId);

		Set<Long> menuIdSet = new HashSet<>();
		for (MenuDto menu : menuListHasPage) {
			String menuPath = menu.getPath();
			String[] paths = menuPath.split(MENU_PATH_SEPERATOR);
			for (int i = 1; i < paths.length - 1; i++) {
				menuIdSet.add(Long.valueOf(paths[i]));
			}
		}

		List<MenuDto> resultMenuList = new ArrayList<>();
		for(MenuDto menu : menuList) {
			if(menuIdSet.contains(menu.getId())) {
				resultMenuList.add(menu);
			}
		}

		return resultMenuList;
	}
}
