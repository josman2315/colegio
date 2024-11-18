package com.colegio.management.application.service.estudiante;

import com.colegio.management.application.dto.EstudianteDTO;
import com.colegio.management.application.mapper.EstudianteMapper;
import com.colegio.management.domain.model.Estudiante;
import com.colegio.management.domain.repository.EstudianteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Override
    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = EstudianteMapper.convertirAEntidad(estudianteDTO);
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return EstudianteMapper.convertirADTO(estudianteGuardado);
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
                .map(EstudianteMapper::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.map(EstudianteMapper::convertirADTO).orElse(null);
    }

    @Override
    @Transactional
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO detallesEstudianteDTO) {
        Optional<Estudiante> estudianteExistenteOpt = estudianteRepository.findById(id);
        if (estudianteExistenteOpt.isPresent()) {
            Estudiante estudianteExistente = estudianteExistenteOpt.get();
            estudianteExistente.setNombre(detallesEstudianteDTO.getNombre());
            Estudiante estudianteActualizado = estudianteRepository.save(estudianteExistente);
            return EstudianteMapper.convertirADTO(estudianteActualizado);
        } else {
            throw new EntityNotFoundException("Estudiante no encontrado con id: " + id);
        }
    }

    @Override
    @Transactional
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}
