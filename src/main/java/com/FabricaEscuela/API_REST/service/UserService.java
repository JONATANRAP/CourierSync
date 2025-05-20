package com.FabricaEscuela.API_REST.service;

import com.FabricaEscuela.API_REST.dto.UserDTO;
import com.FabricaEscuela.API_REST.dto.UserUpdateDto;
import com.FabricaEscuela.API_REST.exception.ApiException;
import com.FabricaEscuela.API_REST.model.Role;
import com.FabricaEscuela.API_REST.model.User;
import com.FabricaEscuela.API_REST.repository.RoleRepository;
import com.FabricaEscuela.API_REST.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new ApiException("Usuario no encontrado"));
    }

    public void update(Long id, UserUpdateDto dto) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ApiException("Usuario no encontrado"));

        if (!user.getEmail().equals(dto.getEmail()) && userRepository.existsByEmail(dto.getEmail())) {
            throw new ApiException("El nuevo email ya está en uso");
        }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        if (dto.getRole_id() != null) {
            Role role = user.getRole();
            if (!role.getRole_id().equals(dto.getRole_id())) {
                Role newRole = roleRepository.findById(dto.getRole_id())
                        .orElseThrow(() -> new ApiException("Rol no encontrado"));
                user.setRole(newRole);
            }
        }

        userRepository.save(user);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ApiException("Usuario no encontrado");
        }
        userRepository.deleteById(id);
    }

    private UserDTO mapToDto(User user) {
        return new UserDTO(user.getUserId(), user.getName(), user.getEmail(), user.getRole().getName());
    }
}
