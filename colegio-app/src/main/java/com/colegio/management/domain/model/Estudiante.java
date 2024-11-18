package com.colegio.management.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estudianteId;

    @Column(length = 100)
    private String nombre;
}
