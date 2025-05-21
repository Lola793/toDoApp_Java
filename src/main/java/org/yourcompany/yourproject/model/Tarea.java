package org.yourcompany.yourproject.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Representa una tarea individual asignada a un usuario y categorizada.
 * <p>
 * Cada tarea puede tener un recordatorio asociado y pertenece a una categoría.
 * El campo 'activa' indica si la tarea está actualmente visible o pendiente para el usuario.
 * El campo 'completada' indica si la tarea ha sido finalizada.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se utiliza JPA para el mapeo objeto-relacional.</li>
 *   <li>Se emplean relaciones ManyToOne y OneToOne para vincular usuario, categoría y recordatorio.</li>
 *   <li>Se usan tipos envoltorio (Boolean) para permitir valores nulos y facilitar validaciones.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Validar campos obligatorios y formatos en el modelo.</li>
 *   <li>Agregar campos de auditoría (fecha de creación, modificación, etc.).</li>
 *   <li>Soporte para subtareas o adjuntos.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see Categoria
 * @see Usuario
 * @see Recordatorio
 */
@Entity // Indica que esta clase es una entidad JPA
public class Tarea {
    /**
     * Identificador único de la tarea. Se genera automáticamente al guardar en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título descriptivo de la tarea. Visible en la lista principal.
     */
    private String titulo;

    /**
     * Descripción detallada de la tarea. Puede estar vacía.
     */
    private String descripcion;

    /**
     * Fecha límite para completar la tarea. Se utiliza para ordenar y filtrar tareas.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLimite;

    /**
     * Indica si la tarea ha sido completada. true = finalizada, false = pendiente.
     */
    private Boolean completada;

    /**
     * Indica si la tarea está activa y debe mostrarse al usuario. false = archivada o desactivada.
     */
    private Boolean activa;

    /**
     * Usuario propietario de la tarea. Relación muchos a uno.
     * @see Usuario
     */
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /**
     * Categoría a la que pertenece la tarea. Relación muchos a uno.
     * @see Categoria
     */
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    /**
     * Recordatorio asociado a la tarea. Relación uno a uno.
     * @see Recordatorio
     */
    @OneToOne(mappedBy = "tarea", cascade = CascadeType.ALL)
    private Recordatorio recordatorio;

    /**
     * Devuelve el identificador único de la tarea.
     * @return id de la tarea generado por la base de datos.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador único de la tarea. Usado internamente por JPA.
     * @param id identificador único generado por la base de datos.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el título de la tarea.
     * @return título visible en la lista de tareas.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Asigna el título de la tarea.
     * @param titulo texto descriptivo que se mostrará al usuario.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve la descripción de la tarea.
     * @return descripción detallada o vacía si no se ha especificado.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripción de la tarea.
     * @param descripcion texto explicativo adicional.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve la fecha límite de la tarea.
     * @return fecha en formato LocalDate.
     */
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    /**
     * Asigna la fecha límite de la tarea.
     * @param fechaLimite fecha máxima para completar la tarea.
     */
    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * Indica si la tarea está completada.
     * @return true si la tarea está finalizada, false si está pendiente.
     */
    public Boolean getCompletada() {
        return completada;
    }

    /**
     * Marca la tarea como completada o pendiente.
     * @param completada true para finalizada, false para pendiente.
     */
    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    /**
     * Indica si la tarea está activa.
     * @return true si la tarea está visible para el usuario, false si está archivada.
     */
    public Boolean getActiva() {
        return activa;
    }

    /**
     * Cambia el estado de actividad de la tarea.
     * @param activa true para mostrar la tarea, false para archivarla.
     */
    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    /**
     * Devuelve el usuario propietario de la tarea.
     * @return objeto Usuario asociado.
     * @see Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Asocia la tarea a un usuario concreto.
     * @param usuario objeto Usuario existente en la base de datos.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve la categoría de la tarea.
     * @return objeto Categoria asociado.
     * @see Categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Asocia la tarea a una categoría concreta.
     * @param categoria objeto Categoria existente en la base de datos.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Devuelve el recordatorio asociado a la tarea.
     * @return objeto Recordatorio o null si no existe.
     * @see Recordatorio
     */
    public Recordatorio getRecordatorio() {
        return recordatorio;
    }

    /**
     * Asocia un recordatorio a la tarea.
     * @param recordatorio objeto Recordatorio a vincular.
     */
    public void setRecordatorio(Recordatorio recordatorio) {
        this.recordatorio = recordatorio;
    }
} 