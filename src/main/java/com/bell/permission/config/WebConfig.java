package com.bell.permission.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bell.permission.api.service.ApiService;
import com.bell.permission.global.filter.AuthorizationFilter;
import com.bell.permission.global.filter.OrganizationFilter;
import com.bell.permission.org.service.OrganizationService;

import jakarta.servlet.Filter;

@Configuration
public class WebConfig {
	@Bean
	public FilterRegistrationBean<Filter> organizationFilterRegisterBean(OrganizationService organizationService) {
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>(
			new OrganizationFilter(organizationService));
		filter.addUrlPatterns("/*");
		filter.setOrder(1);

		return filter;
	}

	@Bean
	public FilterRegistrationBean<Filter> authorizationFilterRegisterBean(ApiService apiService) {
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>(new AuthorizationFilter(apiService));
		filter.addUrlPatterns("/*");
		filter.setOrder(2);

		return filter;
	}
}
