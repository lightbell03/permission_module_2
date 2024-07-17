package com.bell.permission.api.repository.impl;

import static com.bell.permission.api.entity.QApiEntity.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bell.permission.api.dto.ApiDto;
import com.bell.permission.api.repository.ApiRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ApiRepositoryCustomImpl implements ApiRepositoryCustom {
	private final JPAQueryFactory query;

	@Override
	public List<ApiDto> findAllApiList() {
		return query.select(Projections.constructor(ApiDto.class,
				apiEntity.id,
				apiEntity.path,
				apiEntity.method))
			.fetch();
	}
}
