package com.bell.permission.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.org.entity.OrganizationEntity;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long>,
	OrganizationJdbcTemplateRepositoryCustom {
}
