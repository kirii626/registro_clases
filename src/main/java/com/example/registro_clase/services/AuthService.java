package com.example.registro_clase.services;

import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public interface AuthService {
    UsuarioOutputDto registerNewUser(UsuarioInputDto usuarioInputDto);

    String authenticateAndGenerateToken(String email, String password);
}
