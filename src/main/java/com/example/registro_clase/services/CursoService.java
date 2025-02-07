package com.example.registro_clase.services;

import com.example.registro_clase.dtos.curso.CursoInputDto;
import com.example.registro_clase.dtos.curso.CursoOutputDto;

import java.util.List;

public interface CursoService {

    List<CursoOutputDto> obtenerTodosLosCursos();
    CursoOutputDto obtenerCursoPorId(Long id);
    CursoOutputDto crearCurso(CursoInputDto dto);
    CursoOutputDto actualizarCurso(Long id, CursoInputDto dto);
    void eliminarCurso(Long id);
}
