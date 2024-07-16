package com.bell.permission.user.repository.impl;

import static com.bell.permission.permissiongroup.entity.QPermissionGroupEntity.*;
import static com.bell.permission.user.entity.QUserEntity.*;
import static com.bell.permission.user.entity.QUserPermissionGroupEntity.*;

import org.springframework.stereotype.Repository;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.user.repository.UserRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	private final JPAQueryFactory query;

	@Override
	public PermissionGroupDto findUserPermissionById(Long userId, Long serviceId) {
		return query.select(Projections.constructor(PermissionGroupDto.class,
				permissionGroupEntity.id,
				permissionGroupEntity.name))
			.innerJoin(userPermissionGroupEntity)
			.on(userPermissionGroupEntity.pk.userId.eq(userEntity.id))
			.innerJoin(permissionGroupEntity)
			.on(permissionGroupEntity.id.eq(userPermissionGroupEntity.pk.permissionGroupId))
			.where(userEntity.id.eq(userId)
				.and(permissionGroupEntity.serviceId.eq(serviceId)))
			.fetchFirst();
	}
}
