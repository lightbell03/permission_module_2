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

	// TODO 조직 생성 기능은 is_super 만 사용가능 -> api 는 권한과 연결되어 있으면 안되는가
	@PostMapping("/organizations")
	public ResponseEntity<Void> createOrganization(
		@RequestBody CreateOrganizationDto createOrganizationDto) {
		organizationService.createOrganization(createOrganizationDto);
		return null;
	}
}
