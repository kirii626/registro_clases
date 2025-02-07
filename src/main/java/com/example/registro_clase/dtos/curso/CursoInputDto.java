package com.example.registro_clase.dtos.curso;

public class CursoInputDto {

    private String nombreCurso;
    private String nivel;
    private int anioEscolar;

    public CursoInputDto() {
    }

    public CursoInputDto(String nombreCurso, String nivel, int anioEscolar) {
        this.nombreCurso = nombreCurso;
        this.nivel = nivel;
        this.anioEscolar = anioEscolar;
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
