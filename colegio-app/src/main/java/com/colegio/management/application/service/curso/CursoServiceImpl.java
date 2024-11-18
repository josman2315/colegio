package com.colegio.management.application.service.curso;

import com.colegio.management.application.dto.CursoDTO;
import com.colegio.management.application.mapper.CursoMapper;
import com.colegio.management.domain.model.Colegio;
import com.colegio.management.domain.model.Curso;
import com.colegio.management.domain.repository.ColegioRepository;
import com.colegio.management.domain.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.colegio.management.application.mapper.CursoMapper.convertirADTO;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final ColegioRepository colegioRepository;

    @Override
    @Transactional
    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        Curso curso = CursoMapper.convertirAEntidad(cursoDTO);
        Curso cursoGuardado = cursoRepository.save(curso);
        return convertirADTO(cursoGuardado);
    }

    @Override
    @Transactional
    public List<CursoDTO> obtenerTodosLosCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream()
                .map(CursoMapper::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public CursoDTO obtenerCursoPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.map(CursoMapper::convertirADTO).orElse(null);
    }

    @Override
    @Transactional
    public CursoDTO actualizarCurso(Long id, CursoDTO detallesCursoDTO) {
        Optional<Curso> cursoExistenteOpt = cursoRepository.findById(id);
        if (cursoExistenteOpt.isPresent()) {
            Curso cursoExistente = cursoExistenteOpt.get();

            cursoExistente.setGrado(detallesCursoDTO.getGrado());
            cursoExistente.setSalon(detallesCursoDTO.getSalon());

            if (detallesCursoDTO.getColegio() != null) {
                Colegio colegio = colegioRepository.findById(detallesCursoDTO.getColegio().getColegioId())
                        .orElseThrow(() -> new EntityNotFoundException("Colegio no encontrado con id: " + detallesCursoDTO.getColegio().getColegioId()));
                cursoExistente.setColegio(colegio);
            }

            Curso cursoActualizado = cursoRepository.save(cursoExistente);

            return CursoMapper.convertirADTO(cursoActualizado);
        } else {
            throw new EntityNotFoundException("Curso no encontrado con id: " + id);
        }
    }

    @Override
    @Transactional
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}