package com.FabricaEscuela.API_REST.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
