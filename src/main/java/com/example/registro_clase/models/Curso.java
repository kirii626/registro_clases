package com.example.registro_clase.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCurso;
    private String nivel;
    private int anioEscolar;

    @ManyToMany
    @JoinTable(
            name = "usuarios_cursos",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> profesores = new HashSet<>();

    @OneToOne(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private Libro libro;

    public Curso() {
    }

    public Curso(String nombreCurso, String nivel, int anioEscolar) {
        this.nombreCurso = nombreCurso;
        this.nivel = nivel;
        this.anioEscolar = anioEscolar;
    }

    public void asignarLibro(Libro libro) {
        this.libro = libro;
        libro.setCurso(this);
    }

    public Long getId() {
        return id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getAnioEscolar() {
        return anioEscolar;
    }

    public void setAnioEscolar(int anioEscolar) {
        this.anioEscolar = anioEscolar;
    }

    public Set<Usuario> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Usuario> profesores) {
        this.profesores = profesores;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", nivel='" + nivel + '\'' +
                ", anioEscolar=" + anioEscolar +
                ", profesores=" + profesores +
                ", libro=" + libro +
                '}';
    }
}
