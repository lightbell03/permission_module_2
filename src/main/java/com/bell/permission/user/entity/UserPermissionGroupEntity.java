package com.bell.permission.user.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_permission_group")
public class UserPermissionGroupEntity {
	@Id
	@EmbeddedId
	private Pk pk;

	@Builder
	public UserPermissionGroupEntity(Long userId, Long permissionGroupId) {
		this.pk = new Pk(userId, permissionGroupId);
	}

	@Embeddable
	@EqualsAndHashCode
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Pk implements Serializable {
		@Column(name = "user_id")
		private Long userId;

		@Column(name = "permission_group_id")
		private Long permissionGroupId;
	}
}
