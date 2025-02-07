package com.example.registro_clase.services.implementations;

import com.example.registro_clase.dtos.clase.ClaseInputDto;
import com.example.registro_clase.dtos.clase.ClaseOutputDto;
import com.example.registro_clase.mappers.ClaseMapper;
import com.example.registro_clase.mappers.CursoMapper;
import com.example.registro_clase.models.Clase;
import com.example.registro_clase.models.Usuario;
import com.example.registro_clase.repositories.ClaseRepository;
import com.example.registro_clase.repositories.UsuarioRespository;
import com.example.registro_clase.services.ClaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;
    private final ClaseMapper claseMapper;
    private final UsuarioRespository usuarioRespository;

    public ClaseServiceImpl(ClaseRepository claseRepository, ClaseMapper claseMapper, UsuarioRespository usuarioRespository) {
        this.claseRepository = claseRepository;
        this.claseMapper = claseMapper;
        this.usuarioRespository = usuarioRespository;
    }

    @Override
    public List<ClaseOutputDto> obtenerTodasLasClases() {
        return claseRepository.findAll().stream()
                .map(claseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClaseOutputDto obtenerClasePorId(Long id) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        return claseMapper.toDto(clase);
    }

    @Override
    public ClaseOutputDto crearClase(ClaseInputDto dto) {
        Usuario profesor = usuarioRespository.findById(dto.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Clase clase = claseMapper.toEntity(dto, profesor);
        clase = claseRepository.save(clase);
        return claseMapper.toDto(clase);
    }

    @Override
    public ClaseOutputDto actualizarClase(Long id, ClaseInputDto dto) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        clase.setFechaClase(dto.getFechaClase());
        clase.setClaseNumero(dto.getClaseNumero());
        clase.setUnidad(dto.getUnidad());
        clase.setCaracterClase(dto.getCaracterClase());
        clase.setContenido(dto.getContenido());
        clase.setTareas(dto.getTareas());
        clase = claseRepository.save(clase);
        return claseMapper.toDto(clase);
    }

    @Override
    public void eliminarClase(Long id) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        claseRepository.delete(clase);
    }
}
