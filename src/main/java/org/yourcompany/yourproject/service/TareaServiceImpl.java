package org.yourcompany.yourproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yourcompany.yourproject.model.Tarea;
import org.yourcompany.yourproject.repository.TareaRepository;

/**
 * Implementación concreta del servicio de tareas.
 * <p>
 * Esta clase contiene la lógica de negocio para gestionar tareas, delegando el acceso a datos
 * en el repositorio correspondiente. Implementa la interfaz {@link TareaService}.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se utiliza la anotación {@code @Service} para indicar que es un componente de negocio.</li>
 *   <li>Se inyecta el repositorio mediante constructor para facilitar el testing y el desacoplamiento.</li>
 *   <li>Se emplean streams para filtrar tareas por categoría.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Optimizar la consulta de filtrado por categoría usando métodos personalizados en el repositorio.</li>
 *   <li>Agregar manejo de errores y validaciones más robustas.</li>
 *   <li>Soporte para paginación y ordenación.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see org.yourcompany.yourproject.model.Tarea
 * @see org.yourcompany.yourproject.repository.TareaRepository
 * @see org.springframework.stereotype.Service
 */
@Service
public class TareaServiceImpl implements TareaService {

    /** Repositorio de acceso a datos para tareas. */
    private final TareaRepository tareaRepository;

    /**
     * Constructor con inyección de dependencias.
     * @param tareaRepository repositorio de tareas
     */
    @Autowired
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Tarea> obtenerPorId(Long id) {
        return tareaRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Se utiliza un stream para filtrar las tareas por el nombre de la categoría.
     * Esto es funcional pero puede ser ineficiente en bases de datos grandes, ya que recupera todas las tareas en memoria.
     * </p>
     */
    @Override
    public List<Tarea> obtenerPorCategoria(String categoria) {
        return tareaRepository.findAll().stream()
                .filter(t -> t.getCategoria().getNombre().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     * <p>
     * Marca la tarea como completada y la desactiva. Si no existe, no hace nada.
     * </p>
     */
    @Override
    public void marcarComoCompletada(Long id) {
        tareaRepository.findById(id).ifPresent(tarea -> {
            tarea.setCompletada(true);
            tarea.setActiva(false);
            tareaRepository.save(tarea);
        });
    }

    /**
     * {@inheritDoc}
     * <p>
     * Activa la tarea y la marca como pendiente. Si no existe, no hace nada.
     * </p>
     */
    @Override
    public void activarTarea(Long id) {
        tareaRepository.findById(id).ifPresent(tarea -> {
            tarea.setActiva(true);
            tarea.setCompletada(false);
            tareaRepository.save(tarea);
        });
    }
} 