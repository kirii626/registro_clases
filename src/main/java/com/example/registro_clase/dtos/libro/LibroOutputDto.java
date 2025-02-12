package com.example.registro_clase.dtos.libro;

import java.time.LocalDateTime;

public class LibroOutputDto {

    private Long id;
    private LocalDateTime fechaCreacion;

    public LibroOutputDto() {
    }

    public LibroOutputDto(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LibroOutputDto(Long id, LocalDateTime fechaCreacion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}
