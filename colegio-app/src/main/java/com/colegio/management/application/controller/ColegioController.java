package com.colegio.management.application.controller;

import com.colegio.management.application.service.colegio.ColegioService;
import com.colegio.management.domain.model.Colegio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colegios")
@RequiredArgsConstructor
public class ColegioController {

    private final ColegioService colegioService;

    @PostMapping
    public ResponseEntity<Colegio> crearColegio(@RequestBody Colegio colegio) {
        Colegio nuevoColegio = colegioService.crearColegio(colegio);
        return ResponseEntity.ok(nuevoColegio);
    }

    @GetMapping
    public ResponseEntity<List<Colegio>> obtenerTodosLosColegios() {
        List<Colegio> colegios = colegioService.obtenerTodosLosColegios();
        return ResponseEntity.ok(colegios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colegio> obtenerColegioPorId(@PathVariable Long id) {
        Colegio colegio = colegioService.obtenerColegioPorId(id);
        return ResponseEntity.ok(colegio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colegio> actualizarColegio(@PathVariable Long id, @RequestBody Colegio detallesColegio) {
        Colegio colegioActualizado = colegioService.actualizarColegio(id, detallesColegio);
        return ResponseEntity.ok(colegioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarColegio(@PathVariable Long id) {
        colegioService.eliminarColegio(id);
        return ResponseEntity.noContent().build();
    }
}