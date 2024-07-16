package com.bell.permission.function.service.impl;

import com.bell.permission.function.dto.FunctionDto;
import com.bell.permission.function.repository.FunctionRepository;
import com.bell.permission.page.service.PageService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bell.permission.function.service.FunctionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FunctionServiceImpl implements FunctionService {
    private final FunctionRepository functionRepository;

    public List<FunctionDto> getFunctionListByPermission(List<Long> permissionIdList) {
        return functionRepository.getFunctionListByPermissionIdList(permissionIdList);
    }
}
