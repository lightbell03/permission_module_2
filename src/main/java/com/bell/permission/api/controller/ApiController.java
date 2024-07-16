package com.bell.permission.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {

	// TODO api 목록 조회, is_super admin 만 조회 가능하며 권한 연결이 되면 안된다.??
	@GetMapping("/apis")
	private ResponseEntity<Void> getApiList() {

		return null;
	}
}
