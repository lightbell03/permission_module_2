package com.bell.permission.page.entity;

import static com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl.*;

import com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl;
import com.bell.permission.org.repository.impl.OrganizationRepositoryCustomImpl;

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
@Table(name = "page", schema = SCHEMA_PATTERN)
public class PageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "page_id")
	private Long id;

	private String path;

	private boolean active;

	public void upatePagePath(String path) {
		this.path = path;
	}
}
