package com.FabricaEscuela.API_REST.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class test{

    @GetMapping
    public String hello() {
        return "Hola desde Swagger!";
    }
}