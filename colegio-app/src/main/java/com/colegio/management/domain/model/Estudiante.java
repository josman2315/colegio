package com.colegio.management.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estudiante_id;

    @Column(length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Asignatura> asignaturas;
}
