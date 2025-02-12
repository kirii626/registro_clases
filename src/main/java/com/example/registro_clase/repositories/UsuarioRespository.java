package com.example.registro_clase.repositories;

import com.example.registro_clase.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRespository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
