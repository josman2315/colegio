package com.colegio.management.application.controller;

import com.colegio.management.application.service.profesor.ProfesorService;
import com.colegio.management.application.dto.ProfesorAsignaturaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @GetMapping("/asignaturas")
    public List<ProfesorAsignaturaResponse> obtenerTodosLosProfesoresConAsignaturasYEstudiantes() {
        return profesorService.obtenerTodosLosProfesoresConAsignaturasYEstudiantes();
    }
}
