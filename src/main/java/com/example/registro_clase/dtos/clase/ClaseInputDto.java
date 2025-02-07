package com.example.registro_clase.dtos.clase;

public class ClaseInputDto {

    private String fechaClase;
    private int claseNumero;
    private String unidad;
    private String caracterClase;
    private String contenido;
    private String tareas;
    private Long profesorId;

    public ClaseInputDto() {
    }

    public ClaseInputDto(String fechaClase, int claseNumero, String unidad, String caracterClase, String contenido, String tareas, Long profesorId) {
        this.fechaClase = fechaClase;
        this.claseNumero = claseNumero;
        this.unidad = unidad;
        this.caracterClase = caracterClase;
        this.contenido = contenido;
        this.tareas = tareas;
        this.profesorId = profesorId;
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

    public Long getProfesorId() {
        return profesorId;
    }
}
