package com.colegio.management.application.service.colegio;

import com.colegio.management.application.dto.ColegioDTO;
import com.colegio.management.application.mapper.ColegioMapper;
import com.colegio.management.domain.model.Colegio;
import com.colegio.management.domain.repository.ColegioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColegioServiceImpl implements ColegioService {

    private final ColegioRepository colegioRepository;

    @Override
    @Transactional
    public ColegioDTO crearColegio(ColegioDTO colegioDTO) {
        Colegio colegio = ColegioMapper.toEntity(colegioDTO);
        Colegio colegioGuardado = colegioRepository.save(colegio);
        return ColegioMapper.toDTO(colegioGuardado);
    }

    @Override
    public List<ColegioDTO> obtenerTodosLosColegios() {
        List<Colegio> colegios = colegioRepository.findAll();
        return colegios.stream()
                .map(ColegioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ColegioDTO obtenerColegioPorId(Long id) {
        Colegio colegio = colegioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Colegio no encontrado con id: " + id));
        return ColegioMapper.toDTO(colegio);
    }

    @Override
    @Transactional
    public ColegioDTO actualizarColegio(Long id, ColegioDTO detallesColegioDTO) {
        Colegio colegioExistente = colegioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Colegio no encontrado con id: " + id));

        colegioExistente.setNombre(detallesColegioDTO.getNombre());

        Colegio colegioActualizado = colegioRepository.save(colegioExistente);
        return ColegioMapper.toDTO(colegioActualizado);
    }

    @Override
    @Transactional
    public void eliminarColegio(Long id) {
        colegioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Colegio no encontrado con id: " + id));
        colegioRepository.deleteById(id);
    }
}
