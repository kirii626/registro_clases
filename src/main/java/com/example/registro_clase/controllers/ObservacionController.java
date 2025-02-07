package com.example.registro_clase.controllers;

import com.example.registro_clase.dtos.observacion.ObservacionInputDto;
import com.example.registro_clase.dtos.observacion.ObservacionOutputDto;
import com.example.registro_clase.services.ObservacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observaciones")
public class ObservacionController {
    private final ObservacionService observacionService;

    public ObservacionController(ObservacionService observacionService) {
        this.observacionService = observacionService;
    }

    @GetMapping
    public List<ObservacionOutputDto> obtenerObservaciones() {
        return observacionService.obtenerTodasLasObservaciones();
    }

    @GetMapping("/{id}")
    public ObservacionOutputDto obtenerObservacionPorId(@PathVariable Long id) {
        return observacionService.obtenerObservacionPorId(id);
    }

    @PostMapping
    public ObservacionOutputDto crearObservacion(@RequestBody ObservacionInputDto dto) {
        return observacionService.crearObservacion(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarObservacion(@PathVariable Long id) {
        observacionService.eliminarObservacion(id);
        return ResponseEntity.noContent().build();
    }
}

