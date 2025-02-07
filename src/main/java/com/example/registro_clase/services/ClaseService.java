package com.example.registro_clase.services;

import com.example.registro_clase.dtos.clase.ClaseInputDto;
import com.example.registro_clase.dtos.clase.ClaseOutputDto;

import java.util.List;

public interface ClaseService {

    List<ClaseOutputDto> obtenerTodasLasClases();
    ClaseOutputDto obtenerClasePorId(Long id);
    ClaseOutputDto crearClase(ClaseInputDto dto);
    ClaseOutputDto actualizarClase(Long id, ClaseInputDto dto);
    void eliminarClase(Long id);
}
