package com.example.registro_clase.repositories;

import com.example.registro_clase.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
