package com.bell.permission.org.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Or;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bell.permission.org.dto.OrganizationDto;
import com.bell.permission.org.repository.OrganizationJdbcTemplateRepositoryCustom;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrganizationJdbcTemplateRepositoryCustomImpl implements OrganizationJdbcTemplateRepositoryCustom {
	public static final String SCHEMA_PATTERN = "#schema";
	private final JdbcTemplate jdbcTemplate;

	@Override
	public void createOrganization(String name) {
		createOrgSchema(name);
		createTable(name);
	}

	private void createOrgSchema(String name) {
		String query = "insert into common.organization "
			+ "(name) "
			+ "values (?) ";

		jdbcTemplate.update(query, name);
	}

	private void createTable(String schema) {
		createService(schema);
		createUser(schema);
		createPermission(schema);
		createPage(schema);
		createApi(schema);
		createFunction(schema);
		createMenu(schema);

		createUserPermission(schema);
		createFunctionPermission(schema);
		createPagePermission(schema);
	}

	private void createService(String schema) {
		String serviceQuery = "create table " + SCHEMA_PATTERN + ".service ("
			+ "id bigserial primary key, "
			+ "name varchar(20) not null"
			+ ");";
		serviceQuery = serviceQuery.replace(SCHEMA_PATTERN, schema);
		jdbcTemplate.execute(serviceQuery);
	}

	private void createUser(String schema) {
		String userQuery = "create table " + SCHEMA_PATTERN + ".'user' "
			+ "("
			+ "user_id bigserial primary key, "
			+ "name varchar(100) not null, "
			+ "password varchar(100) not null "
			+ ");";
		userQuery = userQuery.replace(SCHEMA_PATTERN, schema);
		jdbcTemplate.execute(userQuery);
	}

	private void createPermission(String schema) {
		String permissionQuery = "create table " + SCHEMA_PATTERN + ".permission_group "
			+ "("
			+ "permission_group_id bigserial primary key, "
			+ "name varchar(20) not null"
			+ ");";
		permissionQuery = permissionQuery.replace(SCHEMA_PATTERN, schema);
		jdbcTemplate.execute(permissionQuery);
	}

	private void createApi(String schema) {
		String apiQuery = "create table " + SCHEMA_PATTERN + ".api "
			+ "("
			+ "api_id bigserial primary key, "
			+ "path varchar(100) not null, "
			+ "method varchar(10) not null"
			+ ");";
		apiQuery = apiQuery.replace("#schema", schema);
		jdbcTemplate.execute(apiQuery);
	}

	private void createFunction(String schema) {
		String functionQuery = "create table " + SCHEMA_PATTERN + ".function "
			+ "("
			+ "function_id bigserial primary key, "
			+ "api_id biginteger, "
			+ "keyword varchar(100), "
			+ "foreign key (api_id) references api (api_id)"
			+ ");";
		functionQuery = functionQuery.replace(SCHEMA_PATTERN, schema);
		jdbcTemplate.execute(functionQuery);
	}

	private void createPage(String shcema) {
		String pageQuery = "create table " + SCHEMA_PATTERN + ".page "
			+ "("
			+ "page_id bigserial primary key, "
			+ "path varchar(100) not null, "
			+ "active bool not null default false"
			+ ")";
		pageQuery = pageQuery.replace(SCHEMA_PATTERN, shcema);
		jdbcTemplate.execute(pageQuery);
	}

	private void createMenu(String schema) {
		String menuQuery = "create table " + SCHEMA_PATTERN + ".menu "
			+ "("
			+ "menu_id bigserial primary key, "
			+ "parent_menu_id biginteger,"
			+ "page_id biginteger, "
			+ "name varchar(100) not null, "
			+ "path varchar(100) not null, "
			+ "foreign key (parent_menu_id) references menu (menu_id), "
			+ "foreign key (page_id) references page (page_id)"
			+ ");";
		menuQuery = menuQuery.replace(SCHEMA_PATTERN, schema);
		jdbcTemplate.execute(menuQuery);
	}

	private void createUserPermission(String schema) {
		String userPermissionQuery = "create table " + SCHEMA_PATTERN + ".user_permission_group "
			+ "("
			+ "permission_group_id biginteger not null, "
			+ "user_id biginteger not null, "
			+ "foreign key permission_group_id references permission_group (permission_group_id), "
			+ "foreign key user_id references 'user' (user_id)"
			+ ");";

		userPermissionQuery = userPermissionQuery.replace(SCHEMA_PATTERN, schema);
		jdbcTemplate.execute(userPermissionQuery);
	}

	private void createPagePermission(String schema) {
		String pagePermissionQuery = "create table " + SCHEMA_PATTERN + ".page_permission_group "
			+ "("
			+ "permission_group_id biginteger not null, "
			+ "page_id biginteger not null, "
			+ "foreign key (permission_group_id) references permission_group (permission_group_id), "
			+ "foreign key (page_id) references page (page_id)"
			+ ");";
		pagePermissionQuery = pagePermissionQuery.replace(SCHEMA_PATTERN, schema);
		jdbcTemplate.execute(pagePermissionQuery);
	}

	private void createFunctionPermission(String schema) {
		String functionPermissionQuery = "create table " + SCHEMA_PATTERN + ".function_permission_group "
			+ "("
			+ "permission_group_id biginteger not null, "
			+ "page_id biginteger not null, "
			+ "foreign key (permission_group_id) references permission_group (permission_group_id), "
			+ "foreign key (page_id) references page (page_id)"
			+ ");";
		functionPermissionQuery = functionPermissionQuery.replace(SCHEMA_PATTERN, schema);
		jdbcTemplate.execute(functionPermissionQuery);
	}

	@Override
	public OrganizationDto getOrganizationByName(String name) {
		String query = "select organization_id as id, name as name "
			+ "from common.organization "
			+ "where name = ?";

		return jdbcTemplate.queryForObject(query, (resultSet, rowNum) -> {
			long id = resultSet.getLong("id");
			String orgName = resultSet.getString("name");
			return new OrganizationDto(id, orgName);
		}, name);
	}

	@Override
	public List<OrganizationDto> getAllOrganizationList() {
		String query = "select organization_id as id, name as name "
			+ "from common.organization ";

		return jdbcTemplate.queryForObject(query, (resultSet, rowNum) -> {
			List<OrganizationDto> result = new ArrayList<>();
			for(int i=0; i<rowNum; i++) {
				long id = resultSet.getLong("id");
				String orgName = resultSet.getString("name");
				result.add(new OrganizationDto(id, orgName));
			}
			return result;
		});
	}
}
