package com.colegio.management.application.mapper;

import com.colegio.management.application.dto.ColegioDTO;
import com.colegio.management.domain.model.Colegio;

public class ColegioMapper {

    public static ColegioDTO toDTO(Colegio colegio) {
        ColegioDTO dto = new ColegioDTO();
        dto.setColegioId(colegio.getColegioId());
        dto.setNombre(colegio.getNombre());
        return dto;
    }

    public static Colegio toEntity(ColegioDTO dto) {
        Colegio colegio = new Colegio();
        colegio.setColegioId(dto.getColegioId());
        colegio.setNombre(dto.getNombre());
        return colegio;
    }
}
