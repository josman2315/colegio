package com.colegio.management.application.mapper;

import com.colegio.management.application.dto.ColegioDTO;
import com.colegio.management.application.dto.CursoDTO;
import com.colegio.management.domain.model.Colegio;
import com.colegio.management.domain.model.Curso;
import com.colegio.management.domain.repository.ColegioRepository;
import jakarta.persistence.EntityNotFoundException;

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

    public static Curso convertirAEntidad(CursoDTO cursoDTO, ColegioRepository colegioRepository) {
        Curso curso = new Curso();
        curso.setCursoId(cursoDTO.getCursoId());
        curso.setGrado(cursoDTO.getGrado());
        curso.setSalon(cursoDTO.getSalon());

        if (cursoDTO.getColegio() != null && cursoDTO.getColegio().getColegioId() != null) {
            Colegio colegio = colegioRepository.findById(cursoDTO.getColegio().getColegioId())
                    .orElseThrow(() -> new EntityNotFoundException("Colegio no encontrado con id: " + cursoDTO.getColegio().getColegioId()));
            curso.setColegio(colegio);
        }

        return curso;
    }
}
