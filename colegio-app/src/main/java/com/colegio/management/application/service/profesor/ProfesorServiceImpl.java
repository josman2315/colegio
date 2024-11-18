package com.colegio.management.application.service.profesor;

import com.colegio.management.application.dto.ProfesorDTO;
import com.colegio.management.application.mapper.ProfesorMapper;
import com.colegio.management.domain.model.Profesor;
import com.colegio.management.domain.repository.ProfesorRepository;
import com.colegio.management.application.dto.ProfesorAsignaturaResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    @Transactional
    public ProfesorDTO crearProfesor(ProfesorDTO profesorDTO) {
        Profesor profesor = ProfesorMapper.convertirAEntidad(profesorDTO);
        Profesor profesorGuardado = profesorRepository.save(profesor);
        return ProfesorMapper.convertirADTO(profesorGuardado);
    }

    @Override
    public List<ProfesorDTO> obtenerTodosLosProfesores() {
        List<Profesor> profesores = profesorRepository.findAll();
        return profesores.stream()
                .map(ProfesorMapper::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProfesorDTO obtenerProfesorPorId(Long id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        return profesor.map(ProfesorMapper::convertirADTO).orElse(null);
    }

    @Override
    @Transactional
    public ProfesorDTO actualizarProfesor(Long id, ProfesorDTO detallesProfesorDTO) {
        Optional<Profesor> profesorExistenteOpt = profesorRepository.findById(id);
        if (profesorExistenteOpt.isPresent()) {
            Profesor profesorExistente = profesorExistenteOpt.get();
            profesorExistente.setNombre(detallesProfesorDTO.getNombre());

            Profesor profesorActualizado = profesorRepository.save(profesorExistente);
            return ProfesorMapper.convertirADTO(profesorActualizado);
        } else {
            throw new EntityNotFoundException("Profesor no encontrado con id: " + id);
        }
    }

    @Override
    @Transactional
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
