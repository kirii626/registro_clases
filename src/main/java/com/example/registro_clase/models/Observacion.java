package com.example.registro_clase.models;

import jakarta.persistence.*;

@Entity
public class Observacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Usuario admin;

    private String comentario;
    private String fecha;

    public Observacion() {
    }

    public Observacion(Clase clase, Usuario admin, String comentario, String fecha) {
        this.clase = clase;
        this.admin = admin;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Usuario getAdmin() {
        return admin;
    }

    public void setAdmin(Usuario admin) {
        this.admin = admin;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Observacion{" +
                "id=" + id +
                ", clase=" + clase +
                ", admin=" + admin +
                ", comentario='" + comentario + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
