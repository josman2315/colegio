package com.colegio.management.application.mapper;

import com.colegio.management.application.dto.ColegioDTO;
import com.colegio.management.application.dto.CursoDTO;
import com.colegio.management.domain.model.Curso;

public class CursoMapper {

    public static CursoDTO convertirADTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setCursoId(curso.getCursoId());
        dto.setGrado(curso.getGrado());
        dto.setSalon(curso.getSalon());

        if (curso.getColegio() != null) {
            ColegioDTO colegioDTO = new ColegioDTO();
            colegioDTO.setColegioId(curso.getColegio().getColegioId());
            colegioDTO.setNombre(curso.getColegio().getNombre());
            dto.setColegio(colegioDTO);
        }
        return dto;
    }

    public static Curso convertirAEntidad(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setCursoId(cursoDTO.getCursoId());
        curso.setGrado(cursoDTO.getGrado());
        curso.setSalon(cursoDTO.getSalon());
        return curso;
    }
}
