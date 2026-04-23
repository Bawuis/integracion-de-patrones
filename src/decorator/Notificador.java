package decorator;

/**
 * Interfaz base del patrón Decorator para notificaciones.
 */
public interface Notificador {

    /**
     * Envía un mensaje de notificación.
     *
     * @param mensaje contenido del mensaje a enviar
     */
    void enviar(String mensaje);
}
