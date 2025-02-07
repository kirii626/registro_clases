package com.example.registro_clase.services.implementations;

import com.example.registro_clase.dtos.libro.LibroInputDto;
import com.example.registro_clase.dtos.libro.LibroOutputDto;
import com.example.registro_clase.mappers.LibroMapper;
import com.example.registro_clase.models.Libro;
import com.example.registro_clase.repositories.LibroRepository;
import com.example.registro_clase.services.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;

    public LibroServiceImpl(LibroRepository libroRepository, LibroMapper libroMapper) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
    }


    @Override
    public List<LibroOutputDto> obtenerTodosLosLibros() {
        return libroRepository.findAll().stream()
                .map(libroMapper::toDto)
                .collect(Collectors.toList());    }

    @Override
    public LibroOutputDto obtenerLibroPorId(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return libroMapper.toDto(libro);    }

    @Override
    public LibroOutputDto crearLibro(LibroInputDto dto) {
        Libro libro = libroMapper.toEntity(dto);
        libro = libroRepository.save(libro);
        return libroMapper.toDto(libro);    }

    @Override
    public void eliminarLibro(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libroRepository.delete(libro);
    }
}
