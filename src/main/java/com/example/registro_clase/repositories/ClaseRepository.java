package com.example.registro_clase.repositories;

import com.example.registro_clase.models.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
}
