package com.bell.permission.user.service;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.user.dto.Accessable;
import com.bell.permission.user.dto.CreateUserDto;
import com.bell.permission.user.dto.CreateUserPermissionGroupDto;
import com.bell.permission.user.dto.LoginResponseDto;
import com.bell.permission.user.dto.UserDto;
import java.util.List;

public interface UserService {
	void createUser(CreateUserDto createUserDto);
	void saveUserPermissionGroup(CreateUserPermissionGroupDto createUserPermissionGroupDto);
	List<PermissionGroupDto> getUserPermission(Long userId, Long serviceId);
	LoginResponseDto login(UserDto userDto);
	Accessable information(Long userId, Long serviceId);
}
