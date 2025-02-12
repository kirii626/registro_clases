package com.example.registro_clase.controllers.administracion;

import com.example.registro_clase.dtos.curso.CursoInputDto;
import com.example.registro_clase.dtos.curso.CursoOutputDto;
import com.example.registro_clase.services.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoOutputDto>> obtenerTodosLosCursos() {
        return ResponseEntity.ok(cursoService.obtenerTodosLosCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoOutputDto> obtenerCursoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.obtenerCursoPorId(id));
    }

    @PostMapping
    public ResponseEntity<CursoOutputDto> crearCurso(@RequestBody CursoInputDto dto) {
        return ResponseEntity.ok(cursoService.crearCurso(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoOutputDto> actualizarCurso(@PathVariable Long id, @RequestBody CursoInputDto dto) {
        return ResponseEntity.ok(cursoService.actualizarCurso(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}