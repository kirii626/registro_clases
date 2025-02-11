package com.example.registro_clase.controllers;

import com.example.registro_clase.config.JwtUtils;
import com.example.registro_clase.dtos.usuario.LoginUsuario;
import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;
import com.example.registro_clase.services.AuthService;
import com.example.registro_clase.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtils jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UsuarioInputDto usuarioInputDto) {
        UsuarioOutputDto createdUser = authService.registerNewUser(usuarioInputDto);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody LoginUsuario loginRequest) {
        String jwt = authService.authenticateAndGenerateToken(
                loginRequest.email(),
                loginRequest.password()
        );

        return ResponseEntity.ok(jwt);
    }
}
