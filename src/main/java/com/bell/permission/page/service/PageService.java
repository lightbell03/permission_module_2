package com.bell.permission.page.service;

import com.bell.permission.page.dto.PageDto;
import java.util.List;

public interface PageService {
    List<PageDto> getPageListByPermissionId(List<Long> permissionIdList, Long serviceId);
}
