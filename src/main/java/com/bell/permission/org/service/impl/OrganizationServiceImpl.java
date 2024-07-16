package com.bell.permission.org.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bell.permission.org.dto.CreateOrganizationDto;
import com.bell.permission.org.dto.OrganizationDto;
import com.bell.permission.org.repository.OrganizationRepository;
import com.bell.permission.org.service.OrganizationService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
	private final OrganizationRepository organizationRepository;

	@Override
	public void createOrganization(CreateOrganizationDto createOrganizationDto) {
		organizationRepository.createOrganization(createOrganizationDto.getName());
	}

	@Override
	public OrganizationDto getOrganization(String name) {
		return organizationRepository.getOrganizationByName(name);
	}
}
