package com.colegio.management.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cursoId;
    private Integer grado;

    @Column(length = 10)
    private String salon;

    @ManyToOne
    @JoinColumn(name = "colegio_id")
    private Colegio colegio;

    @OneToMany(mappedBy = "curso")
    private List<Asignatura> asignaturas;
}