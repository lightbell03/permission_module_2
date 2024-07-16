package com.bell.permission.global.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.bell.permission.dto.OrganizationInfo;
import com.bell.permission.org.dto.OrganizationDto;
import com.bell.permission.org.service.OrganizationService;
import com.bell.permission.utils.OrganizationContextHolder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrganizationFilter implements Filter {
	private final OrganizationService organizationService;
	private static final String DEFAULT_SERVICE = "bell";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {
		OrganizationDto organization = organizationService.getOrganization(DEFAULT_SERVICE);
		OrganizationContextHolder.setOrganization(new OrganizationInfo(organization.getId(), organization.getName()));

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		OrganizationContextHolder.clear();
	}
}
