package com.colegio.management.application.controller;

import com.colegio.management.application.dto.ProfesorDTO;
import com.colegio.management.application.service.profesor.ProfesorService;
import com.colegio.management.application.dto.ProfesorAsignaturaResponse;
import com.colegio.management.domain.model.Profesor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<ProfesorDTO> crearProfesor(@RequestBody ProfesorDTO profesor) {
        ProfesorDTO nuevoProfesor = profesorService.crearProfesor(profesor);
        return ResponseEntity.ok(nuevoProfesor);
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> obtenerTodosLosProfesores() {
        List<ProfesorDTO> profesores = profesorService.obtenerTodosLosProfesores();
        return ResponseEntity.ok(profesores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> obtenerProfesorPorId(@PathVariable Long id) {
        ProfesorDTO profesor = profesorService.obtenerProfesorPorId(id);
        if (profesor != null) {
            return ResponseEntity.ok(profesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDTO> actualizarProfesor(@PathVariable Long id, @RequestBody ProfesorDTO detallesProfesor) {
        ProfesorDTO profesorActualizado = profesorService.actualizarProfesor(id, detallesProfesor);
        return ResponseEntity.ok(profesorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/asignaturas")
    public ResponseEntity<List<ProfesorAsignaturaResponse>> obtenerTodosLosProfesoresConAsignaturasYEstudiantes
            () {
        List<ProfesorAsignaturaResponse> respuesta = profesorService.obtenerTodosLosProfesoresConAsignaturasYEstudiantes();
        return ResponseEntity.ok(respuesta);
    }
}