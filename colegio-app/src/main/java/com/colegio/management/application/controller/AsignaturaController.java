package com.colegio.management.application.controller;

import com.colegio.management.application.dto.AsignaturaDTO;
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
    public ResponseEntity<AsignaturaDTO> crearAsignatura(@RequestBody Asignatura asignatura) {
        AsignaturaDTO nuevaAsignatura = asignaturaService.crearAsignatura(asignatura);
        return ResponseEntity.ok(nuevaAsignatura);
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaDTO>> obtenerTodasLasAsignaturas() {
        List<AsignaturaDTO> asignaturas = asignaturaService.obtenerTodasLasAsignaturas();
        return ResponseEntity.ok(asignaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> obtenerAsignaturaPorId(@PathVariable Long id) {
        AsignaturaDTO asignatura = asignaturaService.obtenerAsignaturaPorId(id);
        return ResponseEntity.ok(asignatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> actualizarAsignatura(@PathVariable Long id, @RequestBody Asignatura detallesAsignatura) {
        AsignaturaDTO asignaturaActualizada = asignaturaService.actualizarAsignatura(id, detallesAsignatura);
        return ResponseEntity.ok(asignaturaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
        return ResponseEntity.noContent().build();
    }
}
