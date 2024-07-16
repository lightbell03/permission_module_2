package com.bell.permission.utils;

import com.bell.permission.dto.OrganizationInfo;

public final class OrganizationContextHolder {
	public OrganizationContextHolder() {}
	private static final ThreadLocal<OrganizationInfo> organizationThreadLocal = new ThreadLocal<>();

	public static void setOrganization(OrganizationInfo organization) {
		organizationThreadLocal.set(organization);
	}

	public static OrganizationInfo getOrganization() {
		return organizationThreadLocal.get();
	}

	public static void clear() {
		organizationThreadLocal.remove();
	}
}
