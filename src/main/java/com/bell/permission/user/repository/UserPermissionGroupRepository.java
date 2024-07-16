package com.bell.permission.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.user.entity.UserPermissionGroupEntity;
import com.bell.permission.user.entity.UserPermissionGroupEntity.Pk;

public interface UserPermissionGroupRepository extends JpaRepository<UserPermissionGroupEntity, Pk> {
}
