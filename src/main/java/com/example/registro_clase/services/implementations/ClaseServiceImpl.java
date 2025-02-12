package com.example.registro_clase.services.implementations;

import com.example.registro_clase.dtos.clase.ClaseInputDto;
import com.example.registro_clase.dtos.clase.ClaseOutputDto;
import com.example.registro_clase.dtos.observacion.ObservacionOutputDto;
import com.example.registro_clase.mappers.ClaseMapper;
import com.example.registro_clase.mappers.CursoMapper;
import com.example.registro_clase.mappers.ObservacionMapper;
import com.example.registro_clase.models.Clase;
import com.example.registro_clase.models.Curso;
import com.example.registro_clase.models.Observacion;
import com.example.registro_clase.models.Usuario;
import com.example.registro_clase.repositories.ClaseRepository;
import com.example.registro_clase.repositories.CursoRepository;
import com.example.registro_clase.repositories.ObservacionRepository;
import com.example.registro_clase.repositories.UsuarioRespository;
import com.example.registro_clase.services.ClaseService;
import com.example.registro_clase.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;
    private final ClaseMapper claseMapper;
    private final UsuarioRespository usuarioRespository;
    private final CursoRepository cursoRepository;
    private final ObservacionMapper observacionMapper;
    private final ObservacionRepository observacionRepository;
    private final SecurityUtils securityUtils;

    public ClaseServiceImpl(ClaseRepository claseRepository, ClaseMapper claseMapper, UsuarioRespository usuarioRespository, CursoRepository cursoRepository, ObservacionMapper observacionMapper, ObservacionRepository observacionRepository, SecurityUtils securityUtils) {
        this.claseRepository = claseRepository;
        this.claseMapper = claseMapper;
        this.usuarioRespository = usuarioRespository;
        this.cursoRepository = cursoRepository;
        this.observacionMapper = observacionMapper;
        this.observacionRepository = observacionRepository;
        this.securityUtils = securityUtils;
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
        String emailProfesor = securityUtils.getCurrentUserEmail()
                .orElseThrow(() -> new RuntimeException("Usuario no autenticado"));

        Usuario profesor = usuarioRespository.findByEmail(emailProfesor)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        // Verificar que el profesor está asignado al curso
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        if (!curso.getProfesores().contains(profesor)) {
            throw new RuntimeException("No tienes permisos para agregar clases a este curso");
        }

        Clase clase = claseMapper.toEntity(dto, profesor);
        clase = claseRepository.save(clase);
        return claseMapper.toDto(clase);
    }

    @Override
    public ClaseOutputDto actualizarClase(Long id, ClaseInputDto dto) {
        String emailProfesor = securityUtils.getCurrentUserEmail()
                .orElseThrow(() -> new RuntimeException("Usuario no autenticado"));

        Usuario profesor = usuarioRespository.findByEmail(emailProfesor)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        if (!clase.getProfesor().equals(profesor)) {
            throw new RuntimeException("No puedes modificar una clase que no registraste");
        }

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

    @Override
    public List<ClaseOutputDto> obtenerClasesPorCurso(Long cursoId) {
        String emailProfesor = securityUtils.getCurrentUserEmail()
                .orElseThrow(() -> new RuntimeException("Usuario no autenticado"));

        Usuario profesor = usuarioRespository.findByEmail(emailProfesor)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        if (!curso.getProfesores().contains(profesor)) {
            throw new RuntimeException("No tienes permisos para ver las clases de este curso");
        }

        List<Clase> clases = claseRepository.findByCursoId(cursoId);
        return claseMapper.toDtoList(clases);
    }

    @Override
    public List<ClaseOutputDto> obtenerHistorialClases(Long cursoId) {
        return obtenerClasesPorCurso(cursoId);
    }

    @Override
    public List<ObservacionOutputDto> obtenerObservacionesDeClase(Long claseId) {
        String emailProfesor = securityUtils.getCurrentUserEmail()
                .orElseThrow(() -> new RuntimeException("Usuario no autenticado"));

        Usuario profesor = usuarioRespository.findByEmail(emailProfesor)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Clase clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        if (!clase.getProfesor().equals(profesor)) {
            throw new RuntimeException("No tienes permisos para ver observaciones de esta clase");
        }

        List<Observacion> observaciones = observacionRepository.findByClaseId(claseId);
        return observacionMapper.toDtoList(observaciones);
    }
}
