package com.bell.permission.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	@PostMapping("/sign-in")
	public ResponseEntity<Void> signIn() {

		return null;
	}

	@PostMapping("/login")
	public ResponseEntity<Void> login() {

		return null;
	}

	@GetMapping("/information")
	public ResponseEntity<Void> information() {

		return null;
	}
}
