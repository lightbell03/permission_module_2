package com.bell.permission.global.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.bell.permission.api.repository.impl.ApiRepositoryCustomImpl;
import com.bell.permission.dto.OrganizationInfo;
import com.bell.permission.org.dto.OrganizationDto;
import com.bell.permission.org.service.OrganizationService;
import com.bell.permission.page.service.PageService;
import com.bell.permission.utils.OrganizationContextHolder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrganizationFilter implements Filter {
	private final OrganizationService organizationService;
	private static final String DEFAULT_SERVICE = "bell";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		OrganizationDto organization = getOrganization(httpRequest);
		// TODO 처리 필요
		if(organization == null) {
			((HttpServletResponse)response).sendError(404);
		}


		OrganizationContextHolder.setOrganization(new OrganizationInfo(organization.getId(), organization.getName()));

		chain.doFilter(request, response);
	}

	private OrganizationDto getOrganization(HttpServletRequest request) {
		String orgName = resolveOrgNameFromUrl(request.getRequestURL().toString());
		return organizationService.getOrganization(orgName);
	}

	private String resolveOrgNameFromUrl(String url) {
		// TODO 도메인 확인 후 조직 추출
		return DEFAULT_SERVICE;
	}


	@Override
	public void destroy() {
		OrganizationContextHolder.clear();
	}
}
