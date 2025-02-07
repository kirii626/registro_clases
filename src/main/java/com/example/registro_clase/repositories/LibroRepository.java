package com.example.registro_clase.repositories;

import com.example.registro_clase.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
