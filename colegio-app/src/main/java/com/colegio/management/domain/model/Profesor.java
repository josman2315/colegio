package com.colegio.management.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profesorId;

    @Column(length = 100)
    private String nombre;

    @OneToMany(mappedBy = "profesor")
    private List<Asignatura> asignaturas;
}
