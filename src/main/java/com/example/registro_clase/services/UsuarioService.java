package com.example.registro_clase.services;

import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioOutputDto> obtenerTodosLosUsuarios();

    UsuarioOutputDto obtenerUsuarioPorId(Long id);

    UsuarioOutputDto crearUsuario(UsuarioInputDto dto);

    UsuarioOutputDto actualizarUsuario(Long id, UsuarioInputDto dto);

    void eliminarUsuario(Long id);
}
