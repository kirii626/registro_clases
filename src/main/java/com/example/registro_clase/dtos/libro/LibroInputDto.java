package com.example.registro_clase.dtos.libro;

public class LibroInputDto {

    private String fechaCreacion;

    public LibroInputDto() {
    }

    public LibroInputDto(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
}


