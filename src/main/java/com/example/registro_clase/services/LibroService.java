package com.example.registro_clase.services;

import com.example.registro_clase.dtos.libro.LibroInputDto;
import com.example.registro_clase.dtos.libro.LibroOutputDto;

import java.util.List;

public interface LibroService {

    List<LibroOutputDto> obtenerTodosLosLibros();
    LibroOutputDto obtenerLibroPorId(Long id);
    LibroOutputDto crearLibro(LibroInputDto dto);
    void eliminarLibro(Long id);

}
