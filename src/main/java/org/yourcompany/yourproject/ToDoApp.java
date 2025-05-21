package org.yourcompany.yourproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca la aplicación To Do App Java con Spring Boot.
 * <p>
 * Esta clase contiene el método main, punto de entrada de la aplicación. Utiliza
 * la anotación {@link SpringBootApplication} para indicar a Spring Boot que debe
 * realizar la configuración automática y el escaneo de componentes.
 * </p>
 *
 * <p><b>¿Por qué se utiliza?</b></p>
 * <ul>
 *   <li>Permite lanzar la aplicación como un servicio web embebido (Tomcat).</li>
 *   <li>Facilita la gestión de dependencias y el ciclo de vida de la app.</li>
 *   <li>El método main es el punto de entrada estándar en Java.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/">Documentación oficial Spring Boot</a>
 */
@SpringBootApplication // Indica que esta clase es la principal de Spring Boot
public class ToDoApp {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     * <p>
     * Utiliza {@link SpringApplication#run(Class, String...)} para arrancar el contexto de Spring,
     * cargar todos los beans y lanzar el servidor embebido.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados habitualmente en apps web Spring Boot)
     */
    public static void main(String[] args) {
        // Llama al método estático run para iniciar la aplicación.
        SpringApplication.run(ToDoApp.class, args);
    }
}
