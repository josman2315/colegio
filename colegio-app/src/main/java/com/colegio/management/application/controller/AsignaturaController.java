package com.colegio.management.application.controller;

import com.colegio.management.application.service.asignatura.AsignaturaService;
import com.colegio.management.domain.model.Asignatura;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
@RequiredArgsConstructor
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    @PostMapping
    public ResponseEntity<Asignatura> crearAsignatura(@RequestBody Asignatura asignatura) {
        Asignatura nuevaAsignatura = asignaturaService.crearAsignatura(asignatura);
        return ResponseEntity.ok(nuevaAsignatura);
    }

    @GetMapping
    public ResponseEntity<List<Asignatura>> obtenerTodasLasAsignaturas() {
        List<Asignatura> asignaturas = asignaturaService.obtenerTodasLasAsignaturas();
        return ResponseEntity.ok(asignaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerAsignaturaPorId(@PathVariable Long id) {
        Asignatura asignatura = asignaturaService.obtenerAsignaturaPorId(id);
        return ResponseEntity.ok(asignatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizarAsignatura(@PathVariable Long id, @RequestBody Asignatura detallesAsignatura) {
        Asignatura asignaturaActualizada = asignaturaService.actualizarAsignatura(id, detallesAsignatura);
        return ResponseEntity.ok(asignaturaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
        return ResponseEntity.noContent().build();
    }
}
