package com.colegio.management.application.service.estudiante;

import com.colegio.management.domain.model.Estudiante;
import com.colegio.management.domain.repository.EstudianteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.orElse(null);
    }

    @Override
    public Estudiante actualizarEstudiante(Long id, Estudiante detallesEstudiante) {
        Optional<Estudiante> estudianteExistenteOpt = estudianteRepository.findById(id);
        if (estudianteExistenteOpt.isPresent()) {
            Estudiante estudianteExistente = estudianteExistenteOpt.get();
            estudianteExistente.setNombre(detallesEstudiante.getNombre());
            estudianteExistente.setAsignaturas(detallesEstudiante.getAsignaturas());
            return estudianteRepository.save(estudianteExistente);
        } else {
            throw new EntityNotFoundException("Estudiante no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}
