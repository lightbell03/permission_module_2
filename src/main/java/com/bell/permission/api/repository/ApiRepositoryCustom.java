package com.bell.permission.api.repository;

import java.util.List;

import com.bell.permission.api.dto.ApiDto;

public interface ApiRepositoryCustom {
	List<ApiDto> findAllApiList();
}
