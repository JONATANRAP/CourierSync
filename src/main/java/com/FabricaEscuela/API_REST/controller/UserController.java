package com.FabricaEscuela.API_REST.controller;

import com.FabricaEscuela.API_REST.dto.UserDTO;
import com.FabricaEscuela.API_REST.dto.UserUpdateDto;
import com.FabricaEscuela.API_REST.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAll();

        users.forEach(user -> {
            user.add(linkTo(methodOn(UserController.class).getUserById(user.getUser_Id())).withSelfRel());
            user.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-users"));
        });

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.findById(id);

        user.add(linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-users"));

        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto dto) {
        userService.update(id, dto);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }
}


