package com.example.registro_clase.controllers.administracion;

import com.example.registro_clase.dtos.libro.LibroInputDto;
import com.example.registro_clase.dtos.libro.LibroOutputDto;
import com.example.registro_clase.services.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroOutputDto> obtenerLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    @GetMapping("/{id}")
    public LibroOutputDto obtenerLibroPorId(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id);
    }

    @PostMapping
    public LibroOutputDto crearLibro(@RequestBody LibroInputDto dto) {
        return libroService.crearLibro(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}
