package com.colegio.management.application.service.profesor;

import com.colegio.management.domain.model.Profesor;
import com.colegio.management.domain.repository.ProfesorRepository;
import com.colegio.management.application.dto.ProfesorAsignaturaResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    @Override
    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor obtenerProfesorPorId(Long id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        return profesor.orElse(null);
    }

    @Override
    public Profesor actualizarProfesor(Long id, Profesor detallesProfesor) {
        Optional<Profesor> profesorExistenteOpt = profesorRepository.findById(id);
        if (profesorExistenteOpt.isPresent()) {
            Profesor profesorExistente = profesorExistenteOpt.get();
            profesorExistente.setNombre(detallesProfesor.getNombre());
            profesorExistente.setAsignaturas(detallesProfesor.getAsignaturas());
            return profesorRepository.save(profesorExistente);
        } else {
            throw new EntityNotFoundException("Profesor no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

    @Override
    public List<ProfesorAsignaturaResponse> obtenerTodosLosProfesoresConAsignaturasYEstudiantes() {
        List<Object[]> results = profesorRepository.findAllProfesoresConAsignaturasYEstudiantes();

        return results.stream()
                .map(row -> new ProfesorAsignaturaResponse(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3]
                ))
                .collect(Collectors.toList());
    }
}
