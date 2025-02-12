package com.example.registro_clase.repositories;

import com.example.registro_clase.models.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase, Long> {

    @Query("SELECT c FROM Clase c WHERE c.libro.curso.id = :cursoId")
    List<Clase> findByCursoId(@Param("cursoId") Long cursoId);}
