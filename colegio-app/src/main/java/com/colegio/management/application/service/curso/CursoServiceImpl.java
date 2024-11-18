package com.colegio.management.application.service.curso;

import com.colegio.management.domain.model.Curso;
import com.colegio.management.domain.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;

    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerCursoPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }

    @Override
    public Curso actualizarCurso(Long id, Curso detallesCurso) {
        Optional<Curso> cursoExistenteOpt = cursoRepository.findById(id);
        if (cursoExistenteOpt.isPresent()) {
            Curso cursoExistente = cursoExistenteOpt.get();
            cursoExistente.setGrado(detallesCurso.getGrado());
            cursoExistente.setSalon(detallesCurso.getSalon());
            cursoExistente.setColegio(detallesCurso.getColegio());
            cursoExistente.setAsignaturas(detallesCurso.getAsignaturas());
            return cursoRepository.save(cursoExistente);
        } else {
            throw new EntityNotFoundException("Curso no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}