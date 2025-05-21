package org.yourcompany.yourproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación.
 * <p>
 * Esta clase gestiona la ruta raíz ("/") y redirige automáticamente a la vista principal de tareas.
 * Es una buena práctica tener un controlador dedicado para la home, ya que permite centralizar la lógica
 * de bienvenida o redirección inicial y facilita futuras ampliaciones (por ejemplo, mostrar un dashboard).
 * </p>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see TareaController
 */
@Controller // Indica que esta clase es un controlador Spring MVC
public class HomeController {
    /**
     * Gestiona la ruta raíz ("/") de la aplicación.
     * <p>
     * Cuando un usuario accede a la raíz, se le redirige automáticamente a la lista de tareas.
     * Esto mejora la experiencia de usuario, ya que siempre verá la sección principal al entrar.
     * </p>
     *
     * @return una redirección a la ruta "/tareas" (Spring interpreta "redirect:" como una orden de redirección HTTP)
     */
    @GetMapping("/")
    public String home() {
        // Redirige a la vista principal de tareas
        return "redirect:/tareas";
    }
} 