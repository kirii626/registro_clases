package com.example.registro_clase.mappers;

import com.example.registro_clase.dtos.clase.ClaseInputDto;
import com.example.registro_clase.dtos.clase.ClaseOutputDto;
import com.example.registro_clase.models.Clase;
import com.example.registro_clase.models.Curso;
import com.example.registro_clase.models.Libro;
import com.example.registro_clase.models.Usuario;
import com.example.registro_clase.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClaseMapper {

    @Autowired
    private CursoRepository cursoRepository;

    public Clase toEntity(ClaseInputDto dto, Usuario profesor) {
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Libro libro = curso.getLibro();
        if (libro == null) {
            throw new RuntimeException("El curso no tiene un libro de temas asignado.");
        }

        Clase clase = new Clase();
        clase.setFechaClase(dto.getFechaClase());
        clase.setClaseNumero(dto.getClaseNumero());
        clase.setUnidad(dto.getUnidad());
        clase.setCaracterClase(dto.getCaracterClase());
        clase.setContenido(dto.getContenido());
        clase.setTareas(dto.getTareas());
        clase.setLibro(libro);
        clase.setProfesor(profesor);

        return clase;
    }

    public ClaseOutputDto toDto(Clase clase) {
        Long cursoId = null;
        if (clase.getLibro() != null && clase.getLibro().getCurso() != null) {
            cursoId = clase.getLibro().getCurso().getId();
        }

        return new ClaseOutputDto(
                clase.getId(),
                clase.getFechaClase(),
                clase.getClaseNumero(),
                clase.getUnidad(),
                clase.getCaracterClase(),
                clase.getContenido(),
                clase.getTareas(),
                clase.getProfesor().getNombre(),
                cursoId
        );
    }

    public List<ClaseOutputDto> toDtoList(List<Clase> clases) {
        return clases.stream().map(this::toDto).collect(Collectors.toList());
    }

}
