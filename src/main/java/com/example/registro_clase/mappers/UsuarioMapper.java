package com.example.registro_clase.mappers;

import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;
import com.example.registro_clase.models.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioInputDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasena(dto.getContrasena());
        return usuario;
    }

    public UsuarioOutputDto toDto(Usuario usuario) {
        return new UsuarioOutputDto(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail()
        );
    }

    public List<Usuario> toEntityList(List<UsuarioInputDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<UsuarioOutputDto> toDtoList(List<Usuario> usuarios) {
        return usuarios.stream().map(this::toDto).collect(Collectors.toList());
    }

}
