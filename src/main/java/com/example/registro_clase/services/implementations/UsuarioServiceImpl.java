package com.example.registro_clase.services.implementations;

import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;
import com.example.registro_clase.exceptions.UserAlreadyExistsExc;
import com.example.registro_clase.mappers.UsuarioMapper;
import com.example.registro_clase.models.Curso;
import com.example.registro_clase.models.Usuario;
import com.example.registro_clase.models.enums.Rol;
import com.example.registro_clase.repositories.CursoRepository;
import com.example.registro_clase.repositories.UsuarioRespository;
import com.example.registro_clase.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRespository usuarioRespository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<UsuarioOutputDto> obtenerTodosLosUsuarios() {
        return usuarioRespository.findAll().stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioOutputDto obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioOutputDto crearUsuario(UsuarioInputDto dto) {
        if (usuarioRespository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsExc("The email already exists: " + dto.getEmail());
        }

        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        usuario = usuarioRespository.save(usuario);
        System.out.println("Email recibido: " + dto.getEmail());
        System.out.println("Contraseña recibida: " + dto.getContrasena());
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioOutputDto actualizarUsuario(Long id, UsuarioInputDto dto) {
        Usuario usuario = usuarioRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasena(dto.getContrasena());
        usuario = usuarioRespository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRespository.delete(usuario);
    }

    @Override
    public void asignarProfesorACurso(Long profesorId, Long cursoId) {
        Usuario profesor = usuarioRespository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        if (!profesor.getRol().equals(Rol.ROLE_PROFESOR)) {
            throw new RuntimeException("El usuario no es un profesor.");
        }

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        curso.getProfesores().add(profesor);
        cursoRepository.save(curso); // 🔹 Guardamos la relación en la BD
    }
}
