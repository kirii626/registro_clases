package com.example.registro_clase.dtos.clase;

import com.example.registro_clase.models.Usuario;

public class ClaseOutputDto {

    private Long id;
    private String fechaClase;
    private int claseNumero;
    private String unidad;
    private String caracterClase;
    private String contenido;
    private String tareas;
    private String profesor;

    public ClaseOutputDto() {
    }

    public ClaseOutputDto(Long id, String fechaClase, int claseNumero, String unidad, String caracterClase, String contenido, String tareas, String profesor) {
        this.id = id;
        this.fechaClase = fechaClase;
        this.claseNumero = claseNumero;
        this.unidad = unidad;
        this.caracterClase = caracterClase;
        this.contenido = contenido;
        this.tareas = tareas;
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public String getFechaClase() {
        return fechaClase;
    }

    public int getClaseNumero() {
        return claseNumero;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getCaracterClase() {
        return caracterClase;
    }

    public String getContenido() {
        return contenido;
    }

    public String getTareas() {
        return tareas;
    }

    public String getProfesor() {
        return profesor;
    }
}


