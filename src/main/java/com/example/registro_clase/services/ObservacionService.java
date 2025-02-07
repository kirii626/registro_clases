package com.example.registro_clase.services;

import com.example.registro_clase.dtos.observacion.ObservacionInputDto;
import com.example.registro_clase.dtos.observacion.ObservacionOutputDto;

import java.util.List;

public interface ObservacionService {

    List<ObservacionOutputDto> obtenerTodasLasObservaciones();
    ObservacionOutputDto obtenerObservacionPorId(Long id);
    ObservacionOutputDto crearObservacion(ObservacionInputDto dto);
    void eliminarObservacion(Long id);

}
