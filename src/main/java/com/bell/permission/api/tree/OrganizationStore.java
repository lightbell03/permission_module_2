package com.bell.permission.api.tree;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class OrganizationStore {
	private final Map<Long, ServiceApiStore> orgServiceApiStoreMap = new ConcurrentHashMap<>();

	public void addOrgServiceApiPermission(Long orgId, Long serviceId, String path, String method, String permission) {
		ServiceApiStore serviceApiStore;
		if(orgServiceApiStoreMap.get(orgId) != null) {
			serviceApiStore = orgServiceApiStoreMap.get(orgId);
		} else {
			serviceApiStore = new ServiceApiStore();
			orgServiceApiStoreMap.put(serviceId, serviceApiStore);
		}
		serviceApiStore.addServiceApiPermission(serviceId, path, method, permission);
	}

	public Map<String, Set<String>> getOrgServiceApiPermission(Long orgId, Long serviceId, String path) {
		if(orgServiceApiStoreMap.containsKey(orgId)) {
			ServiceApiStore serviceApiStore = orgServiceApiStoreMap.get(orgId);
			if(serviceApiStore != null) {
				return serviceApiStore.getServiceApiPermission(serviceId, path);
			}
		}
		return null;
	}
}
