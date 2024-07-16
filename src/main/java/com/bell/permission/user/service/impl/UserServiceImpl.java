package com.bell.permission.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bell.permission.permissiongroup.dto.PermissionGroupDto;
import com.bell.permission.user.dto.UserDto;
import com.bell.permission.user.entity.UserEntity;
import com.bell.permission.user.entity.UserPermissionGroupEntity;
import com.bell.permission.user.repository.UserPermissionGroupRepository;
import com.bell.permission.user.repository.UserRepository;
import com.bell.permission.user.service.UserService;
import com.bell.permission.user.dto.CreateUserDto;
import com.bell.permission.user.dto.CreateUserPermissionGroupDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserPermissionGroupRepository userPermissionGroupRepository;

	@Override
	public void createUser(CreateUserDto createUserDto) {
		UserEntity user = UserEntity.builder()
			.name(createUserDto.getName())
			.password(createUserDto.getPassword())
			.build();

		userRepository.save(user);
	}

	@Override
	public void saveUserPermissionGroup(CreateUserPermissionGroupDto createUserPermissionGroupDto) {
		UserPermissionGroupEntity userPermissionGroupEntity = UserPermissionGroupEntity.builder()
			.userId(createUserPermissionGroupDto.getUserId())
			.permissionGroupId(createUserPermissionGroupDto.getPermissionId())
			.build();
		userPermissionGroupRepository.save(userPermissionGroupEntity);
	}

	@Override
	public PermissionGroupDto getUserPerimssion(Long userId, Long serviceId) {
		return userRepository.findUserPermissionById(userId, serviceId);
	}

	@Override
	public void login(UserDto userDto) {
		userRepository.findByName(userDto.)
	}
}
