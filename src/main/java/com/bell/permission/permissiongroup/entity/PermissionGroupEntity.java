package com.bell.permission.permissiongroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "permission_group")
public class PermissionGroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permission_group_id")
	private Long id;

	@Column(unique = true)
	private String name;

	private Long serviceId;

	@Builder
	public PermissionGroupEntity(String name, Long serviceId) {
		this.name = name;
		this.serviceId = serviceId;
	}

	public void updateName(String permissionName) {
		this.name = name;
	}
}
