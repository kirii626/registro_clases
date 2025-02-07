package com.example.registro_clase.controllers;

import com.example.registro_clase.dtos.clase.ClaseInputDto;
import com.example.registro_clase.dtos.clase.ClaseOutputDto;
import com.example.registro_clase.services.ClaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public List<ClaseOutputDto> obtenerClases() {
        return claseService.obtenerTodasLasClases();
    }

    @GetMapping("/{id}")
    public ClaseOutputDto obtenerClasePorId(@PathVariable Long id) {
        return claseService.obtenerClasePorId(id);
    }

    @PostMapping
    public ClaseOutputDto crearClase(@RequestBody ClaseInputDto dto) {
        return claseService.crearClase(dto);
    }

    @PutMapping("/{id}")
    public ClaseOutputDto actualizarClase(@PathVariable Long id, @RequestBody ClaseInputDto dto) {
        return claseService.actualizarClase(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClase(@PathVariable Long id) {
        claseService.eliminarClase(id);
        return ResponseEntity.noContent().build();
    }
}

