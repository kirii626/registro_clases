package com.example.registro_clase.controllers;


import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;
import com.example.registro_clase.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioOutputDto>> obtenerTodosLosUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerTodosLosUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOutputDto> obtenerUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioOutputDto> crearUsuario(@RequestBody UsuarioInputDto dto) {
        return ResponseEntity.ok(usuarioService.crearUsuario(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioOutputDto> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioInputDto dto) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
