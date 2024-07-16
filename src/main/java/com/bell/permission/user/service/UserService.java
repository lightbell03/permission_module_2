package com.bell.permission.user.service;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.user.dto.CreateUserDto;
import com.bell.permission.user.dto.CreateUserPermissionGroupDto;
import com.bell.permission.user.dto.UserDto;

public interface UserService {
	void createUser(CreateUserDto createUserDto);
	void saveUserPermissionGroup(CreateUserPermissionGroupDto createUserPermissionGroupDto);
	PermissionGroupDto getUserPerimssion(Long userId, Long serviceId);
	void login(UserDto userDto);
}
