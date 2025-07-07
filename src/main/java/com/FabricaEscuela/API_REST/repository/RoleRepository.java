package com.FabricaEscuela.API_REST.repository;

import com.FabricaEscuela.API_REST.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(@Param("name") String name);
}
