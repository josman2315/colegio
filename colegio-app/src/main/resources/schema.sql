-- Tabla Colegio
CREATE TABLE Colegio (
    colegio_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla Curso
CREATE TABLE Curso (
    curso_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    grado INT NOT NULL,
    salon VARCHAR(10),
    colegio_id BIGINT,
    CONSTRAINT fk_curso_colegio FOREIGN KEY (colegio_id) REFERENCES Colegio(colegio_id) ON DELETE SET NULL
);

-- Tabla Profesor
CREATE TABLE Profesor (
    profesor_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla Asignatura
CREATE TABLE Asignatura (
    asignatura_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    profesor_id BIGINT,
    curso_id BIGINT,
    CONSTRAINT fk_asignatura_profesor FOREIGN KEY (profesor_id) REFERENCES Profesor(profesor_id) ON DELETE SET NULL,
    CONSTRAINT fk_asignatura_curso FOREIGN KEY (curso_id) REFERENCES Curso(curso_id) ON DELETE SET NULL
);

-- Tabla Estudiante
CREATE TABLE Estudiante (
    estudiante_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla intermedia para la relación muchos a muchos entre Estudiante y Asignatura
CREATE TABLE Estudiante_Asignatura (
    estudiante_id BIGINT,
    asignatura_id BIGINT,
    PRIMARY KEY (estudiante_id, asignatura_id),
    CONSTRAINT fk_estudiante_asignatura_estudiante FOREIGN KEY (estudiante_id) REFERENCES Estudiante(estudiante_id) ON DELETE CASCADE,
    CONSTRAINT fk_estudiante_asignatura_asignatura FOREIGN KEY (asignatura_id) REFERENCES Asignatura(asignatura_id) ON DELETE CASCADE
);