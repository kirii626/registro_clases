package com.example.registro_clase.dtos.libro;

public class LibroOutputDto {

    private Long id;
    private String fechaCreacion;

    public LibroOutputDto() {
    }

    public LibroOutputDto(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LibroOutputDto(Long id, String fechaCreacion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
}
