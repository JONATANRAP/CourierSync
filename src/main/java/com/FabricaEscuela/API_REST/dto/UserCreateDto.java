package com.FabricaEscuela.API_REST.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private String name;
    private String email;
    private String password;
    private Long role_id;
}
