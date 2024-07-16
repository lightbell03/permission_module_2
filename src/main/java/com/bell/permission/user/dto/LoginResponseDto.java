package com.bell.permission.user.dto;

import com.bell.permission.service.dto.ServiceDto;
import java.util.List;

public class LoginResponseDto {
    private Long id;
    private List<ServiceDto> services;

    public LoginResponseDto(Long id, List<ServiceDto> services) {
        this.id = id;
        this.services = services;
    }
}
