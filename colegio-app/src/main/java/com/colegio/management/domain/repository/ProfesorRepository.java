package com.colegio.management.domain.repository;

import com.colegio.management.domain.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    @Query(value = """
            SELECT  p.nombre AS docente,
                    a.nombre AS materia,
                    CONCAT(c.grado, ' ', c.salon) AS curso,
                    GROUP_CONCAT(e.nombre ORDER BY e.nombre SEPARATOR ', ') AS estudiantes
            FROM Profesor p
            INNER JOIN  Asignatura a ON p.profesor_id = a.profesor_id
            INNER JOIN  Curso c ON a.curso_id = c.curso_id
            LEFT JOIN   Estudiante_Asignatura ea ON a.asignatura_id = ea.asignatura_id
            LEFT JOIN   Estudiante e ON ea.estudiante_id = e.estudiante_id
            GROUP BY p.nombre, a.nombre, curso
            ORDER BY p.nombre, a.nombre, curso
            """, nativeQuery = true)
    List<Object[]> findAllProfesoresConAsignaturasYEstudiantes();
}
