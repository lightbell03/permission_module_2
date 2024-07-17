package com.bell.permission.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bell.permission.user.dto.Accessable;
import com.bell.permission.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	@PostMapping("/sign-in")
	public ResponseEntity<Void> signIn() {

		return null;
	}

	@PostMapping("/login")
	public ResponseEntity<Void> login() {

		return null;
	}

	@GetMapping("/information/{test}")
	public ResponseEntity<Accessable> information() {
		return ResponseEntity.status(HttpStatus.OK)
			.body(userService.information(null, null));
	}
}
