package com.FabricaEscuela.API_REST.repository;

import com.FabricaEscuela.API_REST.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@Param("email") String email);
    boolean existsByEmail(String email);
}