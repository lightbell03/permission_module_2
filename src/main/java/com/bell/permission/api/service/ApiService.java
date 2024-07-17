package com.bell.permission.api.service;

import java.util.List;
import java.util.Set;

public interface ApiService {
	boolean isAccessableApiOfPermission(Long orgId, Long serviceId, String path, Set<String> permissionNameSet);
}
