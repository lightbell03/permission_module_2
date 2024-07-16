package com.bell.permission.function.entity;

import static com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl.*;

import java.io.Serializable;

import com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl;

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
@Table(name = "function_permission_group", schema = SCHEMA_PATTERN)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FunctionPermissionGroupEntity {
	@Id
	@EmbeddedId
	private Pk pk;

	@Builder
	public FunctionPermissionGroupEntity(Long functionId, Long permissionId, Long pageId) {
		this.pk = new Pk(functionId, permissionId, pageId);
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public static class Pk implements Serializable {
		@Column(name = "function_id")
		private Long functionId;
		@Column(name = "permission_group_id")
		private Long permissionGroupId;
		@Column(name = "page_id")
		private Long pageId;
	}
}
