package com.bell.permission.service.dto;

import lombok.Getter;

@Getter
public class ServiceDto {
    private Long id;
    private String name;

    public ServiceDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
