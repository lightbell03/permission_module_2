package com.bell.permission.org.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bell.permission.org.dto.CreateOrganizationDto;
import com.bell.permission.org.service.OrganizationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrganizationController {
	private final OrganizationService organizationService;

	// 외부 서비스 혹은 조직을 관리하는 새로운 어드민 페이지
	@PostMapping("/organizations")
	public ResponseEntity<Void> createOrganization(
		@RequestBody CreateOrganizationDto createOrganizationDto) {
		organizationService.createOrganization(createOrganizationDto);
		return null;
	}
}
