package com.bell.permission.utils;

import com.bell.permission.dto.UserInfo;

public final class UserContextHolder {
	private UserContextHolder() {

	}

	private static final ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<>();

	public static UserInfo get() {
		return userInfoThreadLocal.get();
	}

	public static void set(Long userId) {
		userInfoThreadLocal.set(new UserInfo(userId));
	}

	public static void clear() {
		userInfoThreadLocal.remove();
	}
}
