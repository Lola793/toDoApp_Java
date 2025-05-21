package org.yourcompany.yourproject.service;

import java.util.List;
import java.util.Optional;

import org.yourcompany.yourproject.model.Tarea;

/**
 * Servicio que define las operaciones de negocio para la gestión de tareas.
 * <p>
 * Esta interfaz abstrae la lógica de manipulación de tareas, permitiendo desacoplar
 * los controladores del acceso a datos y facilitando la implementación de diferentes estrategias.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se define una interfaz para facilitar la inyección de dependencias y el testing.</li>
 *   <li>Se abstraen las operaciones CRUD y algunas operaciones de negocio específicas.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Agregar manejo de excepciones personalizadas.</li>
 *   <li>Soporte para paginación y filtrado avanzado.</li>
 *   <li>Validaciones de negocio más complejas.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see org.yourcompany.yourproject.model.Tarea
 */
public interface TareaService {

    /**
     * Obtiene la lista de todas las tareas.
     * @return lista de tareas existentes
     */
    List<Tarea> obtenerTodas();

    /**
     * Busca una tarea por su identificador.
     * @param id identificador único de la tarea
     * @return un Optional con la tarea encontrada o vacío si no existe
     */
    Optional<Tarea> obtenerPorId(Long id);

    /**
     * Guarda una tarea nueva o actualiza una existente.
     * @param tarea objeto Tarea a guardar
     * @return la tarea guardada (con id actualizado si es nueva)
     */
    Tarea guardar(Tarea tarea);

    /**
     * Elimina una tarea por su identificador.
     * @param id identificador de la tarea a eliminar
     */
    void eliminar(Long id);

    /**
     * Obtiene la lista de tareas filtradas por nombre de categoría.
     * @param categoria nombre de la categoría
     * @return lista de tareas que pertenecen a esa categoría
     */
    List<Tarea> obtenerPorCategoria(String categoria);

    /**
     * Marca una tarea como completada y la desactiva.
     * @param id identificador de la tarea a completar
     */
    void marcarComoCompletada(Long id);

    /**
     * Activa una tarea (la vuelve a poner como pendiente).
     * @param id identificador de la tarea a activar
     */
    void activarTarea(Long id);
} 