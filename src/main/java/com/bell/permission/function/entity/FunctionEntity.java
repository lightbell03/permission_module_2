package com.bell.permission.function.entity;

import static com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl.*;

import com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "function", schema = SCHEMA_PATTERN)
public class FunctionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "function_id")
	private Long id;

	@Column(name = "api_id")
	private Long apiId;

	private String keyword;

	public void updateKeyword(String keyword) {
		this.keyword = keyword;
	}
}
