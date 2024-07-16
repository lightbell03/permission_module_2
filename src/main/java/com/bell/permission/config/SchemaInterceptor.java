package com.bell.permission.config;

import static com.bell.permission.org.repository.impl.OrganizationJdbcTemplateRepositoryCustomImpl.*;

import org.hibernate.resource.jdbc.spi.StatementInspector;

import com.bell.permission.utils.OrganizationContextHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchemaInterceptor implements StatementInspector {
	@Override
	public String inspect(String sql) {
		String schema = OrganizationContextHolder.getOrganization().getName();
		return sql.replace(SCHEMA_PATTERN, schema);
	}
}
