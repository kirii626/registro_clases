package com.example.registro_clase.mappers;

import com.example.registro_clase.dtos.libro.LibroInputDto;
import com.example.registro_clase.dtos.libro.LibroOutputDto;
import com.example.registro_clase.models.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public Libro toEntity(LibroInputDto dto) {
        Libro libro = new Libro();
        libro.setFechaCreacion(dto.getFechaCreacion());
        return libro;
    }

    public LibroOutputDto toDto(Libro libro) {
        return new LibroOutputDto(
                libro.getId(),
                libro.getFechaCreacion()
        );
    }

}
