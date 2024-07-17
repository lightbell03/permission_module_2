package com.bell.permission.permissiongroup.repository.impl;

import static com.bell.permission.permissiongroup.entity.QPermissionGroupEntity.*;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.permissiongroup.repository.PermissionGroupRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PermissionGroupRepositoryCustomImpl implements PermissionGroupRepositoryCustom {
	private final JPAQueryFactory query;

	@Override
	public PermissionGroupDto findPermissionGroupByName(String permissionName, Long serviceId) {
		return query.select(Projections.constructor(PermissionGroupDto.class,
			permissionGroupEntity.id,
			permissionGroupEntity.name))
			.where(permissionGroupEntity.name.eq(permissionName)
				.and(permissionGroupEntity.serviceId.eq(serviceId)))
			.fetchFirst();
	}

	@Override
	public List<PermissionGroupDto> findPermissionGroupByName(Set<String> permissionNameSet,
		Long serviceId) {
		return query.select(Projections.constructor(PermissionGroupDto.class,
			permissionGroupEntity.id,
			permissionGroupEntity.name))
			.where(permissionGroupEntity.name.in(permissionNameSet)
				.and(permissionGroupEntity.serviceId.eq(serviceId)))
			.fetch();
	}
}
