package com.FabricaEscuela.API_REST.service;


import com.FabricaEscuela.API_REST.exception.ApiException;
import com.FabricaEscuela.API_REST.model.Role;
import com.FabricaEscuela.API_REST.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ApiException("Rol no encontrado"));
    }
}
