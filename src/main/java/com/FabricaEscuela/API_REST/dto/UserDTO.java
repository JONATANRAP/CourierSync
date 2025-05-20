package com.FabricaEscuela.API_REST.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long user_id;
    private String name;
    private String email;
    private String role;
}
