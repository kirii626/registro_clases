package com.example.registro_clase.services.implementations;

import com.example.registro_clase.dtos.curso.CursoInputDto;
import com.example.registro_clase.dtos.curso.CursoOutputDto;
import com.example.registro_clase.mappers.CursoMapper;
import com.example.registro_clase.models.Curso;
import com.example.registro_clase.repositories.CursoRepository;
import com.example.registro_clase.services.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoServiceImpl(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    @Override
    public List<CursoOutputDto> obtenerTodosLosCursos() {
        return cursoRepository.findAll().stream()
                .map(cursoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CursoOutputDto obtenerCursoPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        return cursoMapper.toDto(curso);
    }

    @Override
    public CursoOutputDto crearCurso(CursoInputDto dto) {
        Curso curso = cursoMapper.toEntity(dto);
        curso = cursoRepository.save(curso);
        return cursoMapper.toDto(curso);
    }

    @Override
    public CursoOutputDto actualizarCurso(Long id, CursoInputDto dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        curso.setNombreCurso(dto.getNombreCurso());
        curso.setNivel(dto.getNivel());
        curso.setAnioEscolar(dto.getAnioEscolar());
        curso = cursoRepository.save(curso);
        return cursoMapper.toDto(curso);
    }

    @Override
    public void eliminarCurso(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        cursoRepository.delete(curso);
    }
}
