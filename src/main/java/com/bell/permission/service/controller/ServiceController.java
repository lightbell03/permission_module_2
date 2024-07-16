package com.bell.permission.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bell.permission.service.dto.CreateServiceDto;
import com.bell.permission.service.service.ServiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ServiceController {
	private final ServiceService serviceService;
	@PostMapping("/services")
	public ResponseEntity<Void> createService(CreateServiceDto createServiceDto) {

		return null;
	}
}
