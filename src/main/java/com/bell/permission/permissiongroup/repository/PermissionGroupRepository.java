package com.bell.permission.permissiongroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.permissiongroup.entity.PermissionGroupEntity;

public interface PermissionGroupRepository extends JpaRepository<PermissionGroupEntity, Long>, PermissionGroupRepositoryCustom {
}
