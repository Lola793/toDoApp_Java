package org.yourcompany.yourproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yourcompany.yourproject.model.Tarea;
import org.yourcompany.yourproject.repository.CategoriaRepository;
import org.yourcompany.yourproject.service.TareaService;

/**
 * Controlador que gestiona las vistas y rutas relacionadas con las tareas.
 * <p>
 * Este controlador se encarga de recibir las peticiones web relacionadas con tareas,
 * comunicarse con el servicio de negocio y preparar los datos para las vistas Thymeleaf.
 * Aquí se centraliza la lógica de presentación y navegación de la sección de tareas.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se utiliza inyección de dependencias para desacoplar la lógica de negocio y acceso a datos.</li>
 *   <li>Se emplean anotaciones de Spring MVC para mapear rutas y métodos HTTP.</li>
 *   <li>Se devuelve el nombre de la plantilla Thymeleaf a renderizar.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Agregar validaciones de formularios y manejo de errores.</li>
 *   <li>Internacionalización de mensajes y rutas.</li>
 *   <li>Soporte para paginación y búsqueda avanzada.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see org.yourcompany.yourproject.model.Tarea
 * @see org.yourcompany.yourproject.service.TareaService
 * @see org.yourcompany.yourproject.repository.CategoriaRepository
 */
@Controller
@RequestMapping("/tareas")
public class TareaController {

    /** Servicio de negocio para operaciones con tareas. */
    private final TareaService tareaService;
    /** Repositorio de categorías para poblar los formularios. */
    private final CategoriaRepository categoriaRepository;

    /**
     * Constructor con inyección de dependencias.
     * @param tareaService servicio de tareas
     * @param categoriaRepository repositorio de categorías
     */
    @Autowired
    public TareaController(TareaService tareaService, CategoriaRepository categoriaRepository) {
        this.tareaService = tareaService;
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Muestra la lista de todas las tareas.
     * <p>
     * Recupera todas las tareas desde el servicio y las añade al modelo para que la vista las muestre.
     * </p>
     * @param model objeto Model de Spring para pasar datos a la vista
     * @return nombre de la plantilla Thymeleaf "lista"
     */
    @GetMapping
    public String listarTareas(Model model) {
        List<Tarea> tareas = tareaService.obtenerTodas(); // Obtiene todas las tareas
        model.addAttribute("tareas", tareas); // Añade la lista al modelo para la vista
        return "lista"; // Renderiza la plantilla "lista.html"
    }

    /**
     * Muestra el formulario para crear una nueva tarea.
     * <p>
     * Prepara un objeto Tarea vacío y la lista de categorías para el formulario.
     * </p>
     * @param model objeto Model de Spring para pasar datos a la vista
     * @return nombre de la plantilla Thymeleaf "formulario"
     */
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tarea", new Tarea()); // Objeto vacío para el formulario
        model.addAttribute("categorias", categoriaRepository.findAll()); // Lista de categorías
        return "formulario"; // Renderiza la plantilla "formulario.html"
    }

    /**
     * Guarda una tarea nueva o modificada.
     * <p>
     * Recibe los datos del formulario, los guarda usando el servicio y redirige a la lista.
     * </p>
     * @param tarea objeto Tarea recibido del formulario
     * @return redirección a la lista de tareas
     */
    @PostMapping("/guardar")
    public String guardarTarea(@ModelAttribute("tarea") Tarea tarea) {
        tareaService.guardar(tarea); // Guarda la tarea (nueva o editada)
        return "redirect:/tareas"; // Redirige a la lista
    }

    /**
     * Marca una tarea como completada.
     * <p>
     * Cambia el estado de la tarea a completada y la desactiva.
     * </p>
     * @param id identificador de la tarea a completar
     * @return redirección a la lista de tareas
     */
    @GetMapping("/completar/{id}")
    public String completarTarea(@PathVariable Long id) {
        tareaService.marcarComoCompletada(id); // Marca como completada
        return "redirect:/tareas";
    }

    /**
     * Elimina una tarea por su identificador.
     * @param id identificador de la tarea a eliminar
     * @return redirección a la lista de tareas
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaService.eliminar(id); // Elimina la tarea
        return "redirect:/tareas";
    }

    /**
     * Activa una tarea manualmente (la vuelve a poner como pendiente).
     * @param id identificador de la tarea a activar
     * @return redirección a la lista de tareas
     */
    @GetMapping("/activar/{id}")
    public String activarTarea(@PathVariable Long id) {
        tareaService.activarTarea(id); // Activa la tarea
        return "redirect:/tareas";
    }

    /**
     * Filtra tareas por nombre de categoría.
     * <p>
     * Permite mostrar solo las tareas de una categoría concreta.
     * </p>
     * @param nombre nombre de la categoría
     * @param model objeto Model para pasar datos a la vista
     * @return nombre de la plantilla Thymeleaf "lista" con las tareas filtradas
     */
    @GetMapping("/categoria/{nombre}")
    public String filtrarPorCategoria(@PathVariable String nombre, Model model) {
        List<Tarea> filtradas = tareaService.obtenerPorCategoria(nombre); // Filtra por categoría
        model.addAttribute("tareas", filtradas); // Añade la lista filtrada
        return "lista"; // Renderiza la plantilla "lista.html"
    }
} 