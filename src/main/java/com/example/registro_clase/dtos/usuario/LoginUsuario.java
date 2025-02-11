package com.example.registro_clase.dtos.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginUsuario(@NotBlank(message = "Email is required")
                           @Email(message = "Invalid email format")
                           String email,

                           @NotBlank(message = "Password is required")
                           String password) {
}
