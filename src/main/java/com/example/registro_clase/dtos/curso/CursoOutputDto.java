package com.example.registro_clase.dtos.curso;

public class CursoOutputDto {

    private Long id;
    private String nombreCurso;
    private String nivel;
    private int anioEscolar;

    public CursoOutputDto() {
    }

    public CursoOutputDto(Long id, String nombreCurso, String nivel, int anioEscolar) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.nivel = nivel;
        this.anioEscolar = anioEscolar;
    }

    public Long getId() {
        return id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getNivel() {
        return nivel;
    }

    public int getAnioEscolar() {
        return anioEscolar;
    }
}
