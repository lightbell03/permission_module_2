package com.bell.permission.function.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.function.entity.FunctionEntity;

public interface FunctionRepository extends JpaRepository<FunctionEntity, Long>, FunctionRepositoryCustom {
}
