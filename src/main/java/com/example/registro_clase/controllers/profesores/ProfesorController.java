package com.example.registro_clase.controllers.profesores;


import com.example.registro_clase.dtos.clase.ClaseInputDto;
import com.example.registro_clase.dtos.clase.ClaseOutputDto;
import com.example.registro_clase.dtos.curso.CursoOutputDto;
import com.example.registro_clase.dtos.observacion.ObservacionOutputDto;
import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;
import com.example.registro_clase.services.ClaseService;
import com.example.registro_clase.services.CursoService;
import com.example.registro_clase.services.UsuarioService;
import com.example.registro_clase.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    private ClaseService claseService;

    @Autowired
    private SecurityUtils securityUtils;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/mis-cursos")
    public ResponseEntity<List<CursoOutputDto>> obtenerMisCursos() {
        String emailProfesor = securityUtils.getCurrentUserEmail()
                .orElseThrow(() -> new RuntimeException("Usuario no autenticado"));

        List<CursoOutputDto> cursos = cursoService.obtenerCursosPorProfesor(emailProfesor);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/clases/{cursoId}")
    public List<ClaseOutputDto> obtenerClasesPorCurso(@PathVariable Long cursoId) {
        return claseService.obtenerClasesPorCurso(cursoId);
    }

    @PostMapping("/clases")
    public ClaseOutputDto registrarClase(@RequestBody ClaseInputDto dto) {
        return claseService.crearClase(dto);
    }

    @PutMapping("/clases/{id}")
    public ClaseOutputDto actualizarClase(@PathVariable Long id, @RequestBody ClaseInputDto dto) {
        return claseService.actualizarClase(id, dto);
    }

    @GetMapping("/historial/{cursoId}")
    public List<ClaseOutputDto> obtenerHistorial(@PathVariable Long cursoId) {
        return claseService.obtenerHistorialClases(cursoId);
    }

    @GetMapping("/observaciones/{claseId}")
    public List<ObservacionOutputDto> obtenerObservaciones(@PathVariable Long claseId) {
        return claseService.obtenerObservacionesDeClase(claseId);
    }
}
