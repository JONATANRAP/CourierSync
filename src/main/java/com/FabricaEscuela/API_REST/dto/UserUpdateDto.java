package com.FabricaEscuela.API_REST.dto;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String name;
    private String email;
    private Long role_id;
}