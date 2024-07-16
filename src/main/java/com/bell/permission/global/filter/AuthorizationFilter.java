package com.bell.permission.global.filter;


import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorizationFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {
		// TODO isSuper 권한 사용자의 경우 무조건 통과
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String authId = servletRequest.getHeader("X-Auth-Id");



		chain.doFilter(request, response);
	}
}
