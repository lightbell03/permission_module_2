package com.bell.permission.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.api.entity.ApiEntity;

public interface ApiRepository extends JpaRepository<ApiEntity, Long>, ApiRepositoryCustom {
}
