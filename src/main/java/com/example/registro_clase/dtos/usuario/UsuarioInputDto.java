package com.example.registro_clase.dtos.usuario;

public class UsuarioInputDto {

    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;

    public UsuarioInputDto() {
    }

    public UsuarioInputDto(String nombre, String apellido, String email, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }
}
