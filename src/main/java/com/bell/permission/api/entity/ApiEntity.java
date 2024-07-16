package com.bell.permission.api.entity;

import static com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl.*;

import com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "api", schema = SCHEMA_PATTERN)
public class ApiEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "api_id")
	private Long id;

	private String path;

	private String method;

	@Builder
	public ApiEntity(String path, String method) {
		this.path = path;
		this.method = method;
	}
}
