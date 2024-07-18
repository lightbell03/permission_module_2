package com.bell.permission.api.tree;

import java.util.Map;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ApiTreeTest {
	ApiTree apiTree = new ApiTree();

	@Test
	void getApiMethodsPermission() {
		String path = "/*/test";
		String method = "get";
		String permission = "ROLE_USER";

		apiTree.addApiPermission(path, method, permission);

		Map<String, Set<String>> result = apiTree.getApiMethodsPermission(path);

		Assertions.assertThat(result.containsKey(method)).isTrue();
		Assertions.assertThat(result.get(method)).hasSize(1);
		Assertions.assertThat(result.get(method)).contains(permission);
	}

	@Test
	void getChildApiNode() {

	}

	@Test
	public void addApiPermission() {

	}
}