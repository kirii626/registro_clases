package com.example.registro_clase.repositories;

import com.example.registro_clase.models.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservacionRepository extends JpaRepository<Observacion, Long> {
    List<Observacion> findByClaseId(Long claseId);
}
