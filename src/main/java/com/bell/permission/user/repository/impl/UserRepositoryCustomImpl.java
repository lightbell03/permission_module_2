package com.bell.permission.user.repository.impl;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.service.dto.ServiceDto;
import com.bell.permission.user.repository.UserRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.bell.permission.permissiongroup.entity.QPermissionGroupEntity.permissionGroupEntity;
import static com.bell.permission.service.entity.QServiceEntity.serviceEntity;
import static com.bell.permission.user.entity.QUserEntity.userEntity;
import static com.bell.permission.user.entity.QUserPermissionGroupEntity.userPermissionGroupEntity;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public List<PermissionGroupDto> findUserPermissionById(Long userId, Long serviceId) {
        return query.select(Projections.constructor(PermissionGroupDto.class,
                        permissionGroupEntity.id,
                        permissionGroupEntity.name))
                .from(userEntity)
                .innerJoin(userPermissionGroupEntity)
                .on(userPermissionGroupEntity.pk.userId.eq(userEntity.id))
                .innerJoin(permissionGroupEntity)
                .on(permissionGroupEntity.id.eq(userPermissionGroupEntity.pk.permissionGroupId))
                .where(userEntity.id.eq(userId)
                        .and(permissionGroupEntity.serviceId.eq(serviceId)))
                .fetch();
    }

    @Override
    public List<ServiceDto> findUserServiceById(Long id) {
        return query.selectDistinct(Projections.constructor(ServiceDto.class,
                        serviceEntity.id,
                        serviceEntity.name))
                .from(userEntity)
                .innerJoin(userPermissionGroupEntity).on(userPermissionGroupEntity.pk.userId.eq(userEntity.id))
                .innerJoin(permissionGroupEntity).on(permissionGroupEntity.id.eq(userPermissionGroupEntity.pk.permissionGroupId))
                .innerJoin(serviceEntity).on(serviceEntity.id.eq(permissionGroupEntity.serviceId))
                .where(userEntity.id.eq(id))
                .fetch();
    }
}
