package com.bell.permission.api.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiNode {
	private String path;
	private Map<String, Set<String>> apiMethodPermission;

	private List<ApiNode> childApiNodeList;

	public ApiNode(String path) {
		this.path = path;
		this.apiMethodPermission = new HashMap<>();
		this.childApiNodeList = new ArrayList<>();
	}

	public void addChildApiNode(ApiNode apiNode) {
		childApiNodeList.add(apiNode);
	}

	public String getPath() {
		return this.path;
	}

	public Map<String, Set<String>> getApiMethodPermission() {
		return apiMethodPermission;
	}

	public boolean isEmptyChildApiNode() {
		return !childApiNodeList.isEmpty();
	}

	public void addPermission(String method, String permission) {
		Set<String> permissionSet;
		if(apiMethodPermission.get(method) != null) {
			permissionSet = apiMethodPermission.get(method);
		} else {
			permissionSet = new HashSet<>();
			apiMethodPermission.put(method, permissionSet);
		}
		permissionSet.add(permission);
	}


	public ApiNode getChildApiNode(String path) {
		for(ApiNode apiNode : childApiNodeList) {
			if(apiNode.getPath().equals(path)) {
				return apiNode;
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApiNode apiNode)) {
			return false;
		}

		return apiNode.path.equals(this.path);
	}
}
