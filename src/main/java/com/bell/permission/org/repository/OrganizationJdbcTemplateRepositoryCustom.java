package com.bell.permission.org.repository;

import com.bell.permission.org.dto.OrganizationDto;

public interface OrganizationJdbcTemplateRepositoryCustom {
	void createOrganization(String name);
	OrganizationDto getOrganizationByName(String name);
}
