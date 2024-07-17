package com.bell.permission.user.service.impl;

import com.bell.permission.function.dto.FunctionDto;
import com.bell.permission.function.service.FunctionService;
import com.bell.permission.menu.dto.MenuDto;
import com.bell.permission.menu.service.MenuService;
import com.bell.permission.menu.service.impl.MenuServiceImpl;
import com.bell.permission.page.dto.PageDto;
import com.bell.permission.page.service.PageService;
import com.bell.permission.permissiongroup.service.PermissionGroupService;
import com.bell.permission.service.dto.ServiceDto;
import com.bell.permission.user.dto.Accessable;
import com.bell.permission.user.dto.LoginResponseDto;
import java.util.ArrayList;
import java.util.List;
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

	private final FunctionService functionService;
	private final PageService pageService;
	private final MenuService menuService;

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
	public List<PermissionGroupDto> getUserPermission(Long userId, Long serviceId) {
		return userRepository.findUserPermissionById(userId, serviceId);
	}

	@Override
	public LoginResponseDto login(UserDto userDto) {
		// TODO 예외 처리
		UserEntity user = userRepository.findByName(userDto.getName())
				.orElseThrow(() -> new RuntimeException("data not found"));

		if(!user.getPassword().equals(userDto.getPassword())) {
			// TODO 예외 처리
			throw new RuntimeException("password not match");
		}

		List<ServiceDto> serviceList = userRepository.findUserServiceById(user.getId());

		return new LoginResponseDto(user.getId(), serviceList);
	}

	@Override
	public Accessable information(Long userId, Long serviceId) {
		List<PermissionGroupDto> permissionGroupList = userRepository.findUserPermissionById(userId, serviceId);

		List<Long> permissionIdList = new ArrayList<>();
		for(PermissionGroupDto permissionGroup : permissionGroupList) {
			permissionIdList.add(permissionGroup.getId());
		}


		// TODO serviceId
		List<PageDto> pageList = pageService.getPageListByPermissionId(permissionIdList, serviceId);
		List<FunctionDto> functionList = functionService.getFunctionListByPermission(permissionIdList, serviceId);
		List<MenuDto> menuList = menuService.getMenuListByPermission(permissionIdList, serviceId);

		return new Accessable(pageList, functionList, menuList);
	}
}
