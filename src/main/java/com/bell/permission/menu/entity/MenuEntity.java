package com.bell.permission.menu.entity;

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
@Table(name = "menu")
public class MenuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Long id;

	private Long parentMenuId;

	private Long pageId;

	private String name;
	private String path;

	@Builder
	public MenuEntity(Long parentMenuId, Long pageId, String name) {
		this.parentMenuId = parentMenuId;
		this.pageId = pageId;
		this.name = name;
	}
}
