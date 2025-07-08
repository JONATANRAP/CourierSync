package com.FabricaEscuela.API_REST.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends RepresentationModel<UserDTO> {
    private Long user_id;
    private String name;
    private String email;
    private String role;

    public Long getUser_Id() {
        return user_id;
    }
}
