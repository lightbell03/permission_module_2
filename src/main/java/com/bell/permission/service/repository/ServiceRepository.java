package com.bell.permission.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bell.permission.service.dto.ServiceDto;
import com.bell.permission.service.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long>, ServiceRepositoryCustom {
}
