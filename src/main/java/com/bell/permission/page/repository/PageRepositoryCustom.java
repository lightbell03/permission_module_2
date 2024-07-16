package com.bell.permission.page.repository;

import java.util.List;

import com.bell.permission.page.dto.PageDto;

public interface PageRepositoryCustom {
	List<PageDto> getPageListByPermissionIdList(List<Long> permissionIdList);
}
