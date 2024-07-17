package com.bell.permission.service.repository.impl;

import static com.bell.permission.service.entity.QServiceEntity.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bell.permission.service.dto.ServiceDto;
import com.bell.permission.service.repository.ServiceRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ServiceRepositoryCustomImpl implements ServiceRepositoryCustom {
	private final JPAQueryFactory query;

	// TODO 확인
	@Override
	public List<ServiceDto> findServiceListByOrgIdList(List<Long> orgIdList) {
		return null;
	}

	@Override
	public List<ServiceDto> findServiceListByOrgId(Long orgId) {
		return query.select(Projections.constructor(ServiceDto.class,
				serviceEntity.id,
				serviceEntity.name))
			.where(serviceEntity.orgId.eq(orgId))
			.fetch();
	}
}
