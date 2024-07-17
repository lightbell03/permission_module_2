package com.bell.permission.api.tree;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceApiStore {
	private final Map<Long, ApiTree> apiTreeMap = new ConcurrentHashMap<>();

	public void addServiceApiPermission(Long serviceId, String path, String method, String permission) {
		serviceId = toZeroIfNull(serviceId);
		ApiTree apiTree;
		if(apiTreeMap.get(serviceId) != null) {
			apiTree = apiTreeMap.get(serviceId);
		} else {
			apiTree = new ApiTree();
			apiTreeMap.put(serviceId, apiTree);
		}
		apiTree.addApiPermission(path, method, permission);
	}

	public Map<String, Set<String>> getServiceApiPermission(Long serviceId, String path) {
		serviceId = toZeroIfNull(serviceId);
		if(apiTreeMap.containsKey(serviceId)) {
			ApiTree apiTree = apiTreeMap.get(serviceId);
			if(apiTree != null) {
				return apiTree.getApiMethodsPermission(path);
			}
		}
		return null;
	}

	private Long toZeroIfNull(Long serviceId) {
		return serviceId == null ? 0L : serviceId;
	}
}
