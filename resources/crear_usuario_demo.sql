-- Script para crear el usuario de pruebas en MySQL
CREATE USER IF NOT EXISTS 'usuario_demo'@'localhost' IDENTIFIED BY 'demo1234';
GRANT ALL PRIVILEGES ON app_tareas_lola.* TO 'usuario_demo'@'localhost';
FLUSH PRIVILEGES;
