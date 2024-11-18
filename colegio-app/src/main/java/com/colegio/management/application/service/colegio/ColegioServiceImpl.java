package com.colegio.management.application.service.colegio;

import com.colegio.management.domain.model.Colegio;
import com.colegio.management.domain.repository.ColegioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColegioServiceImpl implements ColegioService {

    private final ColegioRepository colegioRepository;

    @Override
    public Colegio crearColegio(Colegio colegio) {
        return colegioRepository.save(colegio);
    }

    @Override
    public List<Colegio> obtenerTodosLosColegios() {
        return colegioRepository.findAll();
    }

    @Override
    public Colegio obtenerColegioPorId(Long id) {
        Optional<Colegio> colegio = colegioRepository.findById(id);
        return colegio.orElse(null);
    }

    @Override
    public Colegio actualizarColegio(Long id, Colegio detallesColegio) {
        Optional<Colegio> colegioExistenteOpt = colegioRepository.findById(id);
        if (colegioExistenteOpt.isPresent()) {
            Colegio colegioExistente = colegioExistenteOpt.get();
            colegioExistente.setNombre(detallesColegio.getNombre());
            colegioExistente.setCursos(detallesColegio.getCursos());
            return colegioRepository.save(colegioExistente);
        } else {
            throw new EntityNotFoundException("Colegio no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminarColegio(Long id) {
        colegioRepository.deleteById(id);
    }
}
