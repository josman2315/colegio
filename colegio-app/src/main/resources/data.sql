-- Insertar Colegio
INSERT INTO Colegio (nombre) VALUES ('El colegio del Olimpo');

-- Insertar Cursos
INSERT INTO Curso (grado, salon, colegio_id) VALUES (10, 'A', 1);
INSERT INTO Curso (grado, salon, colegio_id) VALUES (10, 'B', 1);
INSERT INTO Curso (grado, salon, colegio_id) VALUES (11, 'A', 1);
INSERT INTO Curso (grado, salon, colegio_id) VALUES (11, 'B', 1);

-- Insertar Profesores
INSERT INTO Profesor (nombre) VALUES ('Némesis');
INSERT INTO Profesor (nombre) VALUES ('Príapo');
INSERT INTO Profesor (nombre) VALUES ('Iris');


-- Insertar Asignaturas
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Matemáticas', 1, 1);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Matemáticas', 2, 1);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Matemáticas', 3, 1);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Matemáticas', 4, 1);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Español', 1, 2);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Español', 2, 2);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Inglés básico', 1, 3);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Inglés avanzado', 2, 3);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Pre Icfes', 3, 1);
INSERT INTO Asignatura (nombre, curso_id, profesor_id) VALUES ('Pre Icfes', 4, 1);

-- Insertar Estudiantes
INSERT INTO Estudiante (nombre) VALUES ('Afrodita');
INSERT INTO Estudiante (nombre) VALUES ('Artemisa');
INSERT INTO Estudiante (nombre) VALUES ('Hefesto');
INSERT INTO Estudiante (nombre) VALUES ('Hermes');
INSERT INTO Estudiante (nombre) VALUES ('Apolo');
INSERT INTO Estudiante (nombre) VALUES ('Atenea');
INSERT INTO Estudiante (nombre) VALUES ('Hera');
INSERT INTO Estudiante (nombre) VALUES ('Hades');
INSERT INTO Estudiante (nombre) VALUES ('Ares');
INSERT INTO Estudiante (nombre) VALUES ('Dionisio');
INSERT INTO Estudiante (nombre) VALUES ('Poseidón');
INSERT INTO Estudiante (nombre) VALUES ('Zeus');

-- Afrodita
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (1, 1);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (1, 5);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (1, 7);

-- Apolo
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (5, 1);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (5, 5);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (5, 7);

-- Ares
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (9, 1);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (9, 5);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (9, 7);

-- Artemisa
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (2, 2);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (2, 6);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (2, 8);

-- Atenea
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (6, 2);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (6, 6);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (6, 8);

-- Dionisio
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (10, 2);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (10, 6);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (10, 8);

-- Hefesto
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (3, 3);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (3, 9);

-- Hera
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (7, 3);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (7, 9);

-- Hermes
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (4, 4);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (4, 10);

-- Hades
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (8, 4);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (8, 10);

-- Poseidon
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (11, 4);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (11, 10);

-- Zeus
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (12, 4);
INSERT INTO Estudiante_Asignatura (estudiante_id, asignatura_id) VALUES (12, 10);

