package com.example.registro_clase.mappers;

import com.example.registro_clase.dtos.observacion.ObservacionInputDto;
import com.example.registro_clase.dtos.observacion.ObservacionOutputDto;
import com.example.registro_clase.models.Clase;
import com.example.registro_clase.models.Observacion;
import com.example.registro_clase.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ObservacionMapper {

    public Observacion toEntity(ObservacionInputDto dto, Usuario admin, Clase clase) {
        Observacion observacion = new Observacion();
        observacion.setComentario(dto.getComentario());
        observacion.setFecha(dto.getFecha());
        observacion.setAdmin(admin);
        observacion.setClase(clase);
        return observacion;
    }

    public ObservacionOutputDto toDto(Observacion observacion) {
        return new ObservacionOutputDto(
                observacion.getId(),
                observacion.getComentario(),
                observacion.getFecha(),
                observacion.getAdmin().getNombre(),
                observacion.getClase().getId()
        );
    }
}
