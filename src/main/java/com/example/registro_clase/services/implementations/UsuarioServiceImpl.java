package com.example.registro_clase.services.implementations;

import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;
import com.example.registro_clase.mappers.UsuarioMapper;
import com.example.registro_clase.models.Usuario;
import com.example.registro_clase.repositories.UsuarioRespository;
import com.example.registro_clase.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRespository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioRespository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<UsuarioOutputDto> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioOutputDto obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioOutputDto crearUsuario(UsuarioInputDto dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioOutputDto actualizarUsuario(Long id, UsuarioInputDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasena(dto.getContrasena());
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }
}
