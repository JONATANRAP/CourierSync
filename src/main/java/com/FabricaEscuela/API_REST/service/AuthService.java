package com.FabricaEscuela.API_REST.service;

import com.FabricaEscuela.API_REST.dto.JwtResponseDto;
import com.FabricaEscuela.API_REST.dto.LoginDto;
import com.FabricaEscuela.API_REST.dto.UserCreateDto;
import com.FabricaEscuela.API_REST.exception.ApiException;
import com.FabricaEscuela.API_REST.model.Role;
import com.FabricaEscuela.API_REST.model.User;
import com.FabricaEscuela.API_REST.repository.RoleRepository;
import com.FabricaEscuela.API_REST.repository.UserRepository;
import com.FabricaEscuela.API_REST.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void register(UserCreateDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new ApiException("Email ya está registrado");
        }

        Role role = roleRepository.findById(dto.getRole_id())
                .orElseThrow(() -> new ApiException("Rol no encontrado"));

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(role);

        userRepository.save(user);
    }

    public JwtResponseDto login(LoginDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ApiException("Credenciales inválidas"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new ApiException("Credenciales inválidas");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().getName());
        return new JwtResponseDto(token, user.getRole().getName());
    }
}
