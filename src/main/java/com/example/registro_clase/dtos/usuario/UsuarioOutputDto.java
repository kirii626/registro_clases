package com.example.registro_clase.dtos.usuario;

public class UsuarioOutputDto {

    private String nombre;
    private String apellido;
    private String email;

    public UsuarioOutputDto() {
    }

    public UsuarioOutputDto(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }
}
