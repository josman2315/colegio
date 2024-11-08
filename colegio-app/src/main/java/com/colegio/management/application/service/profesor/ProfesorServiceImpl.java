package com.colegio.management.application.service.profesor;

import com.colegio.management.application.service.profesor.ProfesorService;
import com.colegio.management.domain.repository.ProfesorRepository;
import com.colegio.management.application.dto.ProfesorAsignaturaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

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
