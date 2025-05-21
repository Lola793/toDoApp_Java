package org.yourcompany.yourproject.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yourcompany.yourproject.model.Categoria;
import org.yourcompany.yourproject.repository.CategoriaRepository;

/**
 * Componente que carga datos iniciales de categorías al arrancar la aplicación.
 * <p>
 * Esta clase implementa {@link CommandLineRunner}, lo que permite ejecutar código automáticamente
 * tras el arranque de Spring Boot. Se utiliza para poblar la base de datos con categorías por defecto
 * si la tabla está vacía, facilitando la experiencia de usuario en la primera ejecución.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se utiliza {@code @Component} para que Spring detecte y gestione la clase automáticamente.</li>
 *   <li>Se comprueba si la tabla está vacía antes de insertar datos para evitar duplicados.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Permitir cargar datos desde un archivo externo o configuración.</li>
 *   <li>Internacionalizar los nombres de las categorías.</li>
 *   <li>Agregar logs para informar del proceso de carga.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see org.springframework.boot.CommandLineRunner
 * @see org.yourcompany.yourproject.model.Categoria
 * @see org.yourcompany.yourproject.repository.CategoriaRepository
 */
@Component
public class CategoriaDataLoader implements CommandLineRunner {

    /** Repositorio de acceso a datos para categorías. */
    private final CategoriaRepository categoriaRepository;

    /**
     * Constructor con inyección de dependencias.
     * @param categoriaRepository repositorio de categorías
     */
    public CategoriaDataLoader(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Método que se ejecuta automáticamente tras el arranque de la aplicación.
     * <p>
     * Si no existen categorías en la base de datos, inserta un conjunto de categorías por defecto.
     * </p>
     * @param args argumentos de línea de comandos (no utilizados)
     */
    @Override
    public void run(String... args) {
        if (categoriaRepository.count() == 0) {
            // Inserta categorías por defecto solo si la tabla está vacía
            categoriaRepository.save(new Categoria("EMOCIONAL", "EMOCIONAL"));
            categoriaRepository.save(new Categoria("ESCOLAR", "ESCOLAR"));
            categoriaRepository.save(new Categoria("AUTOCUIDADO", "AUTOCUIDADO"));
            categoriaRepository.save(new Categoria("SOCIAL", "SOCIAL"));
            categoriaRepository.save(new Categoria("ENTRETENIMIENTO", "ENTRETENIMIENTO"));
        }
    }
} 