package com.bell.permission.page.repository.impl;

import static com.bell.permission.page.entity.QPageEntity.*;
import static com.bell.permission.page.entity.QPagePermissionGroupEntity.*;
import static com.bell.permission.permissiongroup.entity.QPermissionGroupEntity.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bell.permission.page.dto.PageDto;
import com.bell.permission.page.repository.PageRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PageRepositoryCustomImpl implements PageRepositoryCustom {
	private final JPAQueryFactory query;

	@Override
	public List<PageDto> getPageListByPermissionIdList(List<Long> permissionIdList, Long serviceId) {
		return query.selectDistinct(Projections.constructor(PageDto.class,
				pageEntity.id,
				pageEntity.path))
			.from(pageEntity)
			.innerJoin(pagePermissionGroupEntity)
			.on(pagePermissionGroupEntity.pk.pageId.eq(pageEntity.id))
			.innerJoin(permissionGroupEntity)
			.on(permissionGroupEntity.id.eq(pagePermissionGroupEntity.pk.permissionGroupId))
			.where(permissionGroupEntity.id.in(permissionIdList)
				.and(permissionGroupEntity.serviceId.eq(serviceId)))
			.fetch();
	}
}
