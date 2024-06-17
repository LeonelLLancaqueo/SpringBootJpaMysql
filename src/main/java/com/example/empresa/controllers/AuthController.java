package com.example.empresa.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.models.AuthResponse;
import com.example.empresa.request.UsuarioRequest;
import com.example.empresa.service.AuthService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    
    private AuthService authService;
    
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UsuarioRequest usuarioRequest) {

        
        return ResponseEntity.ok(authService.login(usuarioRequest));
    }
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UsuarioRequest usuarioRequest) {

        return ResponseEntity.ok(authService.register(usuarioRequest));
    }
    
    
}

