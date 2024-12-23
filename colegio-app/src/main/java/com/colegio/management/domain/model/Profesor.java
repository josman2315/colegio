package com.colegio.management.domain.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profesorId;

    @Column(length = 100)
    private String nombre;
}
