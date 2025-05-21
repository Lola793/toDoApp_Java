package org.yourcompany.yourproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Representa una categoría para agrupar tareas según su tipo (emocional, escolar, etc.).
 * <p>
 * Cada categoría puede tener varias tareas asociadas. El campo "tipo" permite distinguir
 * entre diferentes dominios o áreas de la vida del usuario.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se utiliza JPA para el mapeo objeto-relacional.</li>
 *   <li>La relación OneToMany permite que una categoría tenga muchas tareas.</li>
 *   <li>Se implementa Serializable para facilitar la transmisión y almacenamiento.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Validar unicidad de nombre y tipo.</li>
 *   <li>Permitir iconos o colores personalizados por categoría.</li>
 *   <li>Soporte para categorías jerárquicas (subcategorías).</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see Tarea
 */
@Entity
public class Categoria implements java.io.Serializable {
    /**
     * Identificador único de la categoría. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la categoría (por ejemplo: "EMOCIONAL").
     */
    private String nombre;

    /**
     * Tipo de la categoría, coincide con el dominio de la tarea.
     */
    private String tipo;

    /**
     * Lista de tareas asociadas a esta categoría.
     * @see Tarea
     */
    @OneToMany(mappedBy = "categoria")
    private List<Tarea> tareas;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Categoria() {
        // Constructor vacío requerido por JPA
    }

    /**
     * Crea una nueva categoría con nombre y tipo especificados.
     * @param nombre nombre de la categoría.
     * @param tipo tipo de la categoría.
     */
    public Categoria(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * Devuelve el identificador único de la categoría.
     * @return id generado por la base de datos.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador único de la categoría.
     * @param id valor generado por la base de datos.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de la categoría.
     * @return nombre de la categoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre de la categoría.
     * @param nombre texto descriptivo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el tipo de la categoría.
     * @return tipo de la categoría.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo de la categoría.
     * @param tipo texto que define el dominio.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la lista de tareas asociadas a la categoría.
     * @return lista de objetos Tarea.
     * @see Tarea
     */
    public List<Tarea> getTareas() {
        return tareas;
    }

    /**
     * Asocia una lista de tareas a la categoría.
     * @param tareas lista de objetos Tarea.
     */
    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
} 