package org.yourcompany.yourproject.model;

/*
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 20/05/2025
 * @see Tarea
 */

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Representa un recordatorio asociado a una tarea.
 * <p>
 * Esta entidad permite programar avisos para tareas concretas, facilitando la gestión del tiempo y la organización.
 * Aunque actualmente no se utiliza en el flujo principal, está preparada para futuras versiones donde se gestionarán avisos y notificaciones.
 * </p>
 *
 * <b>Decisiones de diseño:</b>
 * <ul>
 *   <li>Se utiliza JPA para el mapeo objeto-relacional.</li>
 *   <li>La relación OneToOne vincula un recordatorio a una única tarea.</li>
 *   <li>El campo hora permite programar el aviso en un momento concreto del día.</li>
 * </ul>
 *
 * <b>Mejoras posibles:</b>
 * <ul>
 *   <li>Permitir recordatorios recurrentes o múltiples por tarea.</li>
 *   <li>Integración con sistemas de notificaciones push o email.</li>
 *   <li>Validar que la hora y el mensaje sean coherentes con la tarea asociada.</li>
 * </ul>
 *
 * @author Lola Fernández Fuentes
 * @version 1.0
 * @since 21/05/25
 * @see Tarea
 */
@Entity
public class Recordatorio {
    /**
     * Identificador único del recordatorio. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Mensaje del recordatorio que se mostrará al usuario.
     */
    private String mensaje;

    /**
     * Hora programada para el recordatorio.
     */
    private LocalTime hora;

    /**
     * Tarea asociada a este recordatorio.
     * @see Tarea
     */
    @OneToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    /**
     * Devuelve el identificador único del recordatorio.
     * @return id generado por la base de datos.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador único del recordatorio.
     * @param id valor generado por la base de datos.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el mensaje del recordatorio.
     * @return texto del mensaje.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Asigna el mensaje del recordatorio.
     * @param mensaje texto a mostrar al usuario.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Devuelve la hora programada del recordatorio.
     * @return hora en formato LocalTime.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Asigna la hora programada del recordatorio.
     * @param hora hora en formato LocalTime.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Devuelve la tarea asociada al recordatorio.
     * @return objeto Tarea asociado.
     * @see Tarea
     */
    public Tarea getTarea() {
        return tarea;
    }

    /**
     * Asocia el recordatorio a una tarea concreta.
     * @param tarea objeto Tarea existente en la base de datos.
     */
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
} 