package org.yourcompany.yourproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yourcompany.yourproject.model.Categoria;

/**
 * Repositorio de acceso a datos para la entidad {@link Categoria}.
 * <p>
 * Esta interfaz hereda de {@link JpaRepository}, lo que proporciona automáticamente
 * métodos CRUD (crear, leer, actualizar, eliminar) y consultas básicas sin necesidad de implementación manual.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se utiliza Spring Data JPA para simplificar el acceso a la base de datos.</li>
 *   <li>No es necesario implementar métodos básicos, ya que JpaRepository los provee.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Definir consultas personalizadas usando métodos de consulta por nombre (query methods).</li>
 *   <li>Agregar paginación y ordenación avanzada.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see org.yourcompany.yourproject.model.Categoria
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Métodos de JpaRepository<Categoria, Long> (no implementar aquí)
} 