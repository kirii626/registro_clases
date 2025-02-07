package com.example.registro_clase.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private Set<Clase> clases = new HashSet<>();

    private String fechaCreacion;

    public Libro() {
    }

    public Libro(Curso curso, Set<Clase> clases, String fechaCreacion) {
        this.curso = curso;
        this.clases = clases;
        this.fechaCreacion = fechaCreacion;
    }

    public void agregarClase(Clase clase) {
        this.clases.add(clase);
        clase.setLibro(this);
    }

    public Long getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Set<Clase> getClases() {
        return clases;
    }

    public void setClases(Set<Clase> clases) {
        this.clases = clases;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", curso=" + curso +
                ", clases=" + clases +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                '}';
    }
}
