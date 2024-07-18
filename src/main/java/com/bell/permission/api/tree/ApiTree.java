package com.bell.permission.api.tree;

import java.util.Map;
import java.util.Set;

public class ApiTree {
	private static final String SLASH = "/";
	private static final ApiNode root = new ApiNode("");

	public ApiNode getChildApiNode(String path) {
		return getChildApiNode(root, path);
	}

	public Map<String, Set<String>> getApiMethodsPermission(String path) {
		ApiNode childApiNode = getChildApiNode(path);
		return childApiNode.getApiMethodPermission();
	}

	private ApiNode getChildApiNode(ApiNode node, String path) {
		// 가장 처음 '/' 는 제거
		String removedFirstSlashPath = path.substring(1);
		String[] paths = removedFirstSlashPath.split(SLASH);

		ApiNode childApiNode = node.getChildApiNode(paths[0]);

		if(childApiNode != null) {
			// 말단까지 일치한 경우
			if (paths.length == 1) {
				return childApiNode;
			} else {
				String nextPath = removedFirstSlashPath.substring(paths[0].length());
				return getChildApiNode(childApiNode, nextPath);
			}
		}

		return null;
	}

	public void addApiPermission(String path, String method, String permission) {
		addApiPermission(root, path, method, permission);
	}

	private void addApiPermission(ApiNode node, String path, String method, String permission) {
		String removedFirstSlashPath = path.substring(1);
		String[] paths = removedFirstSlashPath.split(SLASH);

		ApiNode childApiNode = node.getChildApiNode(paths[0]);
		// api 가 없다면
		if(childApiNode == null) {
			ApiNode nextNode = new ApiNode(paths[0]);
			node.addChildApiNode(nextNode);
			// 말단인 경우
			if(paths.length == 1) {
				nextNode.addPermission(method,permission);
			} else {
				// 말단이 아닌 경우 child 가 없으므로 child 추가 후 다음 노드로 이동
				String nextPath = removedFirstSlashPath.substring(paths[0].length());
				addApiPermission(nextNode, nextPath, method, permission);
			}
		} else {
			// childNode 가 말단인 경우
			if(paths.length == 1) {
				childApiNode.addPermission(method, permission);
			} else {
				// childNode 가 있는데 말단이 아닌 경우
				String nextPath = removedFirstSlashPath.substring(paths[0].length());
				addApiPermission(childApiNode, nextPath, method, permission);
			}
		}
	}
}
