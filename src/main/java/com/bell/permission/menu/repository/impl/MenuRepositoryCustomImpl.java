package com.bell.permission.menu.repository.impl;

import static com.bell.permission.menu.entity.QMenuEntity.*;
import static com.bell.permission.page.entity.QPageEntity.*;
import static com.bell.permission.page.entity.QPagePermissionGroupEntity.*;
import static com.bell.permission.permissiongroup.entity.QPermissionGroupEntity.*;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.bell.permission.menu.dto.MenuDto;
import com.bell.permission.menu.repository.MenuRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryCustomImpl implements MenuRepositoryCustom {
	private final JPAQueryFactory query;

	@Override
	public List<MenuDto> findAllMenuList() {
		return query.selectDistinct(Projections.constructor(MenuDto.class,
				menuEntity.id,
				menuEntity.parentMenuId,
				menuEntity.name,
				pageEntity.path,
				menuEntity.path))
			.leftJoin(pageEntity).on(pageEntity.id.eq(menuEntity.pageId))
			.fetch();
	}

	@Override
	public List<MenuDto> findMenuListByIdList(List<Long> menuIdList) {
		return query.select(Projections.constructor(MenuDto.class,
				menuEntity.id,
				menuEntity.parentMenuId,
				menuEntity.name,
				pageEntity.path,
				menuEntity.path))
			.leftJoin(pageEntity).on(pageEntity.id.eq(menuEntity.pageId))
			.where(menuEntity.id.in(menuIdList))
			.fetch();
	}

	@Override
	public List<MenuDto> findMenuListHasPageByPermission(List<Long> permissionIdList, Long serviceId) {
		return query.selectDistinct(Projections.constructor(MenuDto.class,
				menuEntity.id,
				menuEntity.parentMenuId,
				menuEntity.name,
				pageEntity.path,
				menuEntity.path))
			.innerJoin(pagePermissionGroupEntity)
			.on(pagePermissionGroupEntity.pk.pageId.eq(menuEntity.pageId))
			.innerJoin(permissionGroupEntity)
			.on(permissionGroupEntity.id.eq(pagePermissionGroupEntity.pk.permissionGroupId))
			.where(permissionGroupEntity.id.in(permissionIdList)
				.and(permissionGroupEntity.serviceId.eq(serviceId)))
			.fetch();
	}
}
