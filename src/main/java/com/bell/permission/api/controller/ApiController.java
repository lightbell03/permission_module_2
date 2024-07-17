package com.bell.permission.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {

	// TODO 슈퍼 계정 (ROLE_SUPER)
	@GetMapping("/apis")
	private ResponseEntity<Void> getApiList() {

		return null;
	}


}
