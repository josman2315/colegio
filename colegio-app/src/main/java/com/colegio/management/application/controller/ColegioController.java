package com.colegio.management.application.controller;

import com.colegio.management.application.dto.ColegioDTO;
import com.colegio.management.application.service.colegio.ColegioService;
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
    public ResponseEntity<ColegioDTO> crearColegio(@RequestBody ColegioDTO colegio) {
        ColegioDTO nuevoColegio = colegioService.crearColegio(colegio);
        return ResponseEntity.ok(nuevoColegio);
    }

    @GetMapping
    public ResponseEntity<List<ColegioDTO>> obtenerTodosLosColegios() {
        List<ColegioDTO> colegios = colegioService.obtenerTodosLosColegios();
        return ResponseEntity.ok(colegios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColegioDTO> obtenerColegioPorId(@PathVariable Long id) {
        ColegioDTO colegio = colegioService.obtenerColegioPorId(id);
        return ResponseEntity.ok(colegio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColegioDTO> actualizarColegio(@PathVariable Long id, @RequestBody ColegioDTO detallesColegio) {
        ColegioDTO colegioActualizado = colegioService.actualizarColegio(id, detallesColegio);
        return ResponseEntity.ok(colegioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarColegio(@PathVariable Long id) {
        colegioService.eliminarColegio(id);
        return ResponseEntity.noContent().build();
    }
}