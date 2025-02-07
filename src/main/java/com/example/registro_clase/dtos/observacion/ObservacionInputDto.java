package com.example.registro_clase.dtos.observacion;

public class ObservacionInputDto {

    private String comentario;
    private String fecha;
    private Long adminId;
    private Long claseId;

    public ObservacionInputDto() {
    }

    public ObservacionInputDto(String comentario, String fecha, Long adminId, Long claseId) {
        this.comentario = comentario;
        this.fecha = fecha;
        this.adminId = adminId;
        this.claseId = claseId;
    }

    public String getComentario() {
        return comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public Long getAdminId() {
        return adminId;
    }

    public Long getClaseId() {
        return claseId;
    }
}
