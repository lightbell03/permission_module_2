package com.bell.permission.page.entity;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "page_permission_group", schema = SCHEMA_PATTERN)
public class PagePermissionGroupEntity {
	@Id
	@EmbeddedId
	private Pk pk;

	@Embeddable
	@EqualsAndHashCode
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Pk implements Serializable {
		@Column(name = "permission_group_id")
		private Long permissionGroupId;

		@Column(name = "page_id")
		private Long pageId;
	}
}
