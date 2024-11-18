package com.colegio.management.application.service.asignatura;

import com.colegio.management.application.dto.AsignaturaDTO;
import com.colegio.management.application.mapper.AsignaturaMapper;
import com.colegio.management.domain.model.Asignatura;
import com.colegio.management.domain.repository.AsignaturaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.colegio.management.application.mapper.AsignaturaMapper.toDTO;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional
    public AsignaturaDTO crearAsignatura(Asignatura asignatura) {
        Asignatura nuevaAsignatura = asignaturaRepository.save(asignatura);
        return toDTO(nuevaAsignatura);
    }

    @Override
    @Transactional
    public List<AsignaturaDTO> obtenerTodasLasAsignaturas() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        return asignaturas.stream().map(AsignaturaMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public AsignaturaDTO obtenerAsignaturaPorId(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con id: " + id));
        return toDTO(asignatura);
    }

    @Override
    @Transactional
    public AsignaturaDTO actualizarAsignatura(Long id, Asignatura detallesAsignatura) {
        Asignatura asignaturaActualizada = asignaturaRepository.findById(id).map(asignaturaExistente -> {
            asignaturaExistente.setNombre(detallesAsignatura.getNombre());
            asignaturaExistente.setProfesor(detallesAsignatura.getProfesor());
            asignaturaExistente.setEstudiantes(detallesAsignatura.getEstudiantes());
            asignaturaExistente.setCurso(detallesAsignatura.getCurso());
            return asignaturaRepository.save(asignaturaExistente);
        }).orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con id: " + id));
        return toDTO(asignaturaActualizada);
    }

    @Override
    @Transactional
    public void eliminarAsignatura(Long id) {
        asignaturaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con id: " + id));
        asignaturaRepository.deleteById(id);
    }

}