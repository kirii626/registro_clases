package com.example.registro_clase.services.implementations;

import com.example.registro_clase.dtos.observacion.ObservacionInputDto;
import com.example.registro_clase.dtos.observacion.ObservacionOutputDto;
import com.example.registro_clase.mappers.ObservacionMapper;
import com.example.registro_clase.models.Clase;
import com.example.registro_clase.models.Observacion;
import com.example.registro_clase.models.Usuario;
import com.example.registro_clase.repositories.ClaseRepository;
import com.example.registro_clase.repositories.ObservacionRepository;
import com.example.registro_clase.repositories.UsuarioRespository;
import com.example.registro_clase.services.ObservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ObservacionServiceImpl implements ObservacionService {

    @Autowired
    private ObservacionRepository observacionRepository;

    @Autowired
    private ObservacionMapper observacionMapper;

    @Autowired
    private UsuarioRespository usuarioRespository;

    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public List<ObservacionOutputDto> obtenerTodasLasObservaciones() {
        return observacionRepository.findAll().stream()
                .map(observacionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ObservacionOutputDto obtenerObservacionPorId(Long id) {
        Observacion observacion = observacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Observación no encontrada"));
        return observacionMapper.toDto(observacion);
    }

    @Override
    public ObservacionOutputDto crearObservacion(ObservacionInputDto dto) {
        Usuario admin = usuarioRespository.findById(dto.getAdminId())
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        Clase clase = claseRepository.findById(dto.getClaseId())
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        Observacion observacion = observacionMapper.toEntity(dto, admin, clase);
        observacion = observacionRepository.save(observacion);
        return observacionMapper.toDto(observacion);
    }

    @Override
    public void eliminarObservacion(Long id) {
        Observacion observacion = observacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Observación no encontrada"));
        observacionRepository.delete(observacion);
    }
}
