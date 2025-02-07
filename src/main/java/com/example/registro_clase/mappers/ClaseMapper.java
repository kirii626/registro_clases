package com.example.registro_clase.mappers;

import com.example.registro_clase.dtos.clase.ClaseInputDto;
import com.example.registro_clase.dtos.clase.ClaseOutputDto;
import com.example.registro_clase.models.Clase;
import com.example.registro_clase.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ClaseMapper {

    public Clase toEntity(ClaseInputDto dto, Usuario profesor) {
        Clase clase = new Clase();
        clase.setFechaClase(dto.getFechaClase());
        clase.setClaseNumero(dto.getClaseNumero());
        clase.setUnidad(dto.getUnidad());
        clase.setCaracterClase(dto.getCaracterClase());
        clase.setContenido(dto.getContenido());
        clase.setTareas(dto.getTareas());
        clase.setProfesor(profesor);
        return clase;
    }

    public ClaseOutputDto toDto(Clase clase) {
        return new ClaseOutputDto(
                clase.getId(),
                clase.getFechaClase(),
                clase.getClaseNumero(),
                clase.getUnidad(),
                clase.getCaracterClase(),
                clase.getContenido(),
                clase.getTareas(),
                clase.getProfesor().getNombre()
        );
    }


}
