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
		if(paths[0].equals(node.getPath())) {
			if(paths.length == 1) {
				// 다음 노드가 없고 매칭이 된 경우
				return node;
			} else {
				// 다음 노드가 있는 경우
				ApiNode nextNode = node.getChildApiNode(paths[1]);
				String nextPath = removedFirstSlashPath.substring(paths[0].length() + 1);
				return getChildApiNode(nextNode, nextPath);
			}
		}

		return null;
	}

	public void addApiPermission(String path, String method, String permission) {
		ApiNode currentApiNode = getChildApiNode(path);

		// TODO path 수정
		String[] splits = path.split(SLASH);
		String terminalPath = splits[splits.length - 1];

		ApiNode apiNode = new ApiNode(terminalPath);
		apiNode.addPermission(method, permission);

		currentApiNode.addChildApiNode(apiNode);
	}
}
