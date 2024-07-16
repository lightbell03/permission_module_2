package com.bell.permission.function.repository.impl;

import static com.bell.permission.api.entity.QApiEntity.*;
import static com.bell.permission.function.entity.QFunctionEntity.*;
import static com.bell.permission.function.entity.QFunctionPermissionGroupEntity.*;
import static com.bell.permission.permissiongroup.entity.QPermissionGroupEntity.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bell.permission.function.dto.FunctionDto;
import com.bell.permission.function.repository.FunctionRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FunctionRepositoryCustomImpl implements FunctionRepositoryCustom {
	private final JPAQueryFactory query;

	@Override
	public List<FunctionDto> getFunctionListByPermissionIdList(List<Long> permissionIdList) {
		return query.select(Projections.constructor(FunctionDto.class,
				functionEntity.id,
				apiEntity.path,
				functionEntity.keyword))
			.from(permissionGroupEntity)
			.innerJoin(functionPermissionGroupEntity).on(functionPermissionGroupEntity.pk.permissionGroupId.eq(permissionGroupEntity.id))
			.innerJoin(functionEntity).on(functionEntity.id.eq(functionPermissionGroupEntity.pk.functionId))
			.leftJoin(apiEntity).on(functionEntity.apiId.eq(apiEntity.id))
			.where(permissionGroupEntity.id.in(permissionIdList))
			.fetch();
	}
}
