package com.example.registro_clase.repositories;

import com.example.registro_clase.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRespository extends JpaRepository<Usuario, Long> {
}
