package com.example.registro_clase.dtos.observacion;

public class ObservacionOutputDto {

    private Long id;
    private String comentario;
    private String fecha;
    private String nombre;
    private Long claseId;

    public ObservacionOutputDto() {
    }

    public ObservacionOutputDto(Long id, String comentario, String fecha, String nombre, Long claseId) {
        this.id = id;
        this.comentario = comentario;
        this.fecha = fecha;
        this.nombre = nombre;
        this.claseId = claseId;
    }

    public Long getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getClaseId() {
        return claseId;
    }
}
