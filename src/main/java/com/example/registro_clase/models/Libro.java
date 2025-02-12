package com.example.registro_clase.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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

    private LocalDateTime fechaCreacion;

    public Libro() {
    }

    public Libro(Curso curso) {
        this.curso = curso;
        this.fechaCreacion = LocalDateTime.now();
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
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
