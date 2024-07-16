package com.bell.permission.user.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
    Optional<UserEntity> findByName(String name);
}
