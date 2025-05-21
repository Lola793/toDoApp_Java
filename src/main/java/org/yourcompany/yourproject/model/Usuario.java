package org.yourcompany.yourproject.model;

/*
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 20/05/2025
 * @see Tarea
 */

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Representa un usuario del sistema.
 * <p>
 * Esta entidad permite asociar tareas a diferentes usuarios, facilitando la personalización y la gestión multiusuario.
 * Aunque actualmente no se utiliza en el flujo principal, está preparada para futuras versiones donde se gestionarán usuarios y roles.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se utiliza JPA para el mapeo objeto-relacional.</li>
 *   <li>La relación OneToMany permite que un usuario tenga muchas tareas.</li>
 *   <li>Se añaden campos para rol y color preferido, pensando en la personalización y control de acceso.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Implementar autenticación y gestión de contraseñas.</li>
 *   <li>Soporte para diferentes roles y permisos.</li>
 *   <li>Validar unicidad de nombre de usuario.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see Tarea
 */
@Entity
public class Usuario {
    /**
     * Identificador único del usuario. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del usuario. Se utilizará para mostrar en la interfaz y asociar tareas.
     */
    private String nombre;

    /**
     * Color preferido del usuario para personalización visual.
     */
    private String colorPreferido;

    /**
     * Rol del usuario (por ejemplo: "admin", "niño", "tutor").
     */
    private String rol;

    /**
     * Lista de tareas asociadas a este usuario.
     * @see Tarea
     */
    @OneToMany(mappedBy = "usuario")
    private List<Tarea> tareas;

    /**
     * Devuelve el identificador único del usuario.
     * @return id generado por la base de datos.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador único del usuario.
     * @param id valor generado por la base de datos.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del usuario.
     * @return nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del usuario.
     * @param nombre texto identificativo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el color preferido del usuario.
     * @return color en formato texto.
     */
    public String getColorPreferido() {
        return colorPreferido;
    }

    /**
     * Asigna el color preferido del usuario.
     * @param colorPreferido texto con el color elegido.
     */
    public void setColorPreferido(String colorPreferido) {
        this.colorPreferido = colorPreferido;
    }

    /**
     * Devuelve el rol del usuario.
     * @return rol asignado.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Asigna el rol del usuario.
     * @param rol texto con el rol (admin, niño, tutor, etc.).
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Devuelve la lista de tareas asociadas al usuario.
     * @return lista de objetos Tarea.
     * @see Tarea
     */
    public List<Tarea> getTareas() {
        return tareas;
    }

    /**
     * Asocia una lista de tareas al usuario.
     * @param tareas lista de objetos Tarea.
     */
    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
} 