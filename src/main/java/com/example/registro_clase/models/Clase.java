package com.example.registro_clase.models;

import jakarta.persistence.*;

@Entity
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    private String fechaClase;
    private int claseNumero;
    private String unidad;
    private String caracterClase;
    private String contenido;
    private String tareas;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Usuario profesor;

    public Clase() {
    }

    public Clase(Libro libro, String fechaClase, int claseNumero, String unidad, String caracterClase, String contenido, String tareas, Usuario profesor) {
        this.libro = libro;
        this.fechaClase = fechaClase;
        this.claseNumero = claseNumero;
        this.unidad = unidad;
        this.caracterClase = caracterClase;
        this.contenido = contenido;
        this.tareas = tareas;
        this.profesor = profesor;
    }

    public void asignarProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(String fechaClase) {
        this.fechaClase = fechaClase;
    }

    public int getClaseNumero() {
        return claseNumero;
    }

    public void setClaseNumero(int claseNumero) {
        this.claseNumero = claseNumero;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getCaracterClase() {
        return caracterClase;
    }

    public void setCaracterClase(String caracterClase) {
        this.caracterClase = caracterClase;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", libro=" + libro +
                ", fechaClase='" + fechaClase + '\'' +
                ", claseNumero=" + claseNumero +
                ", unidad='" + unidad + '\'' +
                ", caracterClase='" + caracterClase + '\'' +
                ", contenido='" + contenido + '\'' +
                ", tareas='" + tareas + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}
