DROP DATABASE IF EXISTS app_tareas_lola;
CREATE DATABASE app_tareas_lola;
USE app_tareas_lola;

CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  color_preferido VARCHAR(30),
  rol VARCHAR(20)
);

CREATE TABLE categorias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  tipo ENUM('EMOCIONAL', 'ESCOLAR', 'AUTOCUIDADO', 'SOCIAL', 'ENTRETENIMIENTO') NOT NULL
);

CREATE TABLE tareas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(150) NOT NULL,
  descripcion TEXT,
  fecha_limite DATE,
  completada BOOLEAN DEFAULT FALSE,
  activa BOOLEAN DEFAULT FALSE,
  usuario_id INT NOT NULL,
  categoria_id INT NOT NULL,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
  FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

CREATE TABLE recordatorios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  mensaje TEXT,
  hora TIME,
  tarea_id INT,
  FOREIGN KEY (tarea_id) REFERENCES tareas(id)
);

-- Categorías base (opcional, solo si quieres poblarlas desde SQL)
INSERT INTO categorias (nombre, tipo) VALUES ('EMOCIONAL', 'EMOCIONAL');
INSERT INTO categorias (nombre, tipo) VALUES ('ESCOLAR', 'ESCOLAR');
INSERT INTO categorias (nombre, tipo) VALUES ('AUTOCUIDADO', 'AUTOCUIDADO');
INSERT INTO categorias (nombre, tipo) VALUES ('SOCIAL', 'SOCIAL');
INSERT INTO categorias (nombre, tipo) VALUES ('ENTRETENIMIENTO', 'ENTRETENIMIENTO');