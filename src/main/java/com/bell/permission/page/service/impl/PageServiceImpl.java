package com.bell.permission.page.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bell.permission.page.dto.PageDto;
import com.bell.permission.page.repository.PageRepository;
import com.bell.permission.page.service.PageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
	private final PageRepository pageRepository;

	@Override
	public List<PageDto> getPageListByPermissionId(List<Long> permissionIdList) {
		return pageRepository.getPageListByPermissionIdList(permissionIdList);
	}
}
