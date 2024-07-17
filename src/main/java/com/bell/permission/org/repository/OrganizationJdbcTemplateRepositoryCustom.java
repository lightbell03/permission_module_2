package com.bell.permission.org.repository;

import java.util.List;

import com.bell.permission.org.dto.OrganizationDto;

public interface OrganizationJdbcTemplateRepositoryCustom {
	void createOrganization(String name);
	OrganizationDto getOrganizationByName(String name);

	List<OrganizationDto> getAllOrganizationList();
}
