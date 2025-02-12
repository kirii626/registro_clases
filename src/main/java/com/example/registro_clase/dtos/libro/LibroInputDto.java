package com.example.registro_clase.dtos.libro;

import java.time.LocalDateTime;

public class LibroInputDto {

    private LocalDateTime fechaCreacion;

    public LibroInputDto() {
    }

    public LibroInputDto(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}


