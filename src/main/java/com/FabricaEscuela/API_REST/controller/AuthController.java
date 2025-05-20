package com.FabricaEscuela.API_REST.controller;


import com.FabricaEscuela.API_REST.dto.JwtResponseDto;
import com.FabricaEscuela.API_REST.dto.LoginDto;
import com.FabricaEscuela.API_REST.dto.UserCreateDto;
import com.FabricaEscuela.API_REST.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserCreateDto dto) {
        authService.register(dto);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginDto dto) {
        JwtResponseDto token = authService.login(dto);
        return ResponseEntity.ok(token);
    }
}
