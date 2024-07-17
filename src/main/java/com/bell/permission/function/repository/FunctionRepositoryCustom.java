package com.bell.permission.function.repository;

import java.util.List;

import com.bell.permission.function.dto.FunctionDto;

public interface FunctionRepositoryCustom {
	List<FunctionDto> getFunctionListByPermissionIdList(List<Long> permissionIdList, Long serviceId);
}
