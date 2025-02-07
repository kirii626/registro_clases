package com.example.registro_clase.mappers;

import com.example.registro_clase.dtos.curso.CursoInputDto;
import com.example.registro_clase.dtos.curso.CursoOutputDto;
import com.example.registro_clase.models.Curso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CursoMapper {

    public Curso toEntity(CursoInputDto dto) {
        Curso curso = new Curso();
        curso.setNombreCurso(dto.getNombreCurso());
        curso.setNivel(dto.getNivel());
        curso.setAnioEscolar(dto.getAnioEscolar());
        return curso;
    }

    public CursoOutputDto toDto(Curso curso) {
        return new CursoOutputDto(
                curso.getId(),
                curso.getNombreCurso(),
                curso.getNivel(),
                curso.getAnioEscolar()
        );
    }

    public List<Curso> toEntityList(List<CursoInputDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<CursoOutputDto> toDtoList(List<Curso> cursos) {
        return cursos.stream().map(this::toDto).collect(Collectors.toList());
    }
}
