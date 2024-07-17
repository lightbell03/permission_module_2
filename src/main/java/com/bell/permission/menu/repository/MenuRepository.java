package com.bell.permission.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.menu.entity.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Long>, MenuRepositoryCustom {
}
