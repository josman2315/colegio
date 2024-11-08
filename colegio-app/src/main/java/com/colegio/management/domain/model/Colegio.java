package com.colegio.management.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Colegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colegioId;

    @Column(length = 100)
    private String nombre;

    @OneToMany(mappedBy = "colegio")
    private List<Curso> cursos;
}