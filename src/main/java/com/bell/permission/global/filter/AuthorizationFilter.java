package com.bell.permission.global.filter;


import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Handler;

import org.springframework.web.servlet.HandlerMapping;

import com.bell.permission.api.service.ApiService;
import com.bell.permission.dto.UserInfo;
import com.bell.permission.utils.OrganizationContextHolder;
import com.bell.permission.utils.UserContextHolder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AuthorizationFilter implements Filter {
	private final String ROLE_SUPER = "ROLE_SUPER";
	private final ApiService apiService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String pathInfo = httpRequest.getPathInfo();
		log.info(pathInfo);
		Set<String> userRoleSet = getUserPermission(httpRequest);
		// TODO ROLE_SUPER 권한 사용자의 경우 무조건 통과 -> is_super
		if(userRoleSet.contains(ROLE_SUPER)) {
			chain.doFilter(request, response);
		} else {
			// TODO API 권한 확인
			// boolean isAccess = apiService.isAccessableApiOfPermission(OrganizationContextHolder.getOrganization().getId(), httpRequest.getRequestURI(), userRoleSet);
			// if(!isAccess) {
			// 	((HttpServletResponse)response).sendError(403);
			// 	return;
			// }

			// !TODO 확인 필요
			Object path = httpRequest.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			// apiService.isAccessableApiOfPermission();
			// TODO 유저 저장 어떻게 할지
			UserContextHolder.set(1L);

			chain.doFilter(request, response);
		}
	}

	private Long getServiceIdFromPath(HttpServletRequest request) {

		return null;
	}

	private Set<String> getUserPermission(HttpServletRequest request) {
		// TODO 사용자 검증 및 권한 조회
		return Set.of(ROLE_SUPER);
	}
}
