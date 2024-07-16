package com.bell.permission.service.entity;

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

@Table(name = "service", schema = OrganizationJdbcTemplateRepositoryCustomImpl.SCHEMA_PATTERN)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ServiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private Long id;

	@Column(unique = true)
	private String name;

	@Builder
	public ServiceEntity(String name) {
		this.name = name;
	}
}
