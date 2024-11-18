package com.colegio.management.application.service.asignatura;

import com.colegio.management.domain.model.Asignatura;
import com.colegio.management.domain.repository.AsignaturaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsegnaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    @Override
    public Asignatura crearAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public List<Asignatura> obtenerTodasLasAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura obtenerAsignaturaPorId(Long id) {
        Optional<Asignatura> asignatura = asignaturaRepository.findById(id);
        return asignatura.orElse(null);
    }

    @Override
    public Asignatura actualizarAsignatura(Long id, Asignatura detallesAsignatura) {
        Optional<Asignatura> asignaturaExistenteOpt = asignaturaRepository.findById(id);
        if (asignaturaExistenteOpt.isPresent()) {
            Asignatura asignaturaExistente = asignaturaExistenteOpt.get();
            asignaturaExistente.setNombre(detallesAsignatura.getNombre());
            asignaturaExistente.setProfesor(detallesAsignatura.getProfesor());
            asignaturaExistente.setEstudiantes(detallesAsignatura.getEstudiantes());
            asignaturaExistente.setCurso(detallesAsignatura.getCurso());
            return asignaturaRepository.save(asignaturaExistente);
        } else {
            throw new EntityNotFoundException("Asignatura no encontrada con id: " + id);
        }
    }

    @Override
    public void eliminarAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }
}