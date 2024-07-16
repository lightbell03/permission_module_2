package com.bell.permission.page.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.page.entity.PageEntity;

public interface PageRepository extends JpaRepository<PageEntity, Long>, PageRepositoryCustom {
}
