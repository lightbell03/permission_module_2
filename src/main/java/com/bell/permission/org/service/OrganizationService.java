package com.bell.permission.org.service;

import java.util.List;

import com.bell.permission.org.dto.CreateOrganizationDto;
import com.bell.permission.org.dto.OrganizationDto;

public interface OrganizationService {
	void createOrganization(CreateOrganizationDto createOrganizationDto);
	OrganizationDto getOrganization(String name);

	List<OrganizationDto> getAllOrganization();
}
