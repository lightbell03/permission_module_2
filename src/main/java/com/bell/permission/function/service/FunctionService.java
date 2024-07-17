package com.bell.permission.function.service;

import com.bell.permission.function.dto.FunctionDto;
import java.util.List;

public interface FunctionService {
    List<FunctionDto> getFunctionListByPermission(List<Long> permissionIdList, Long serviceId);
}
