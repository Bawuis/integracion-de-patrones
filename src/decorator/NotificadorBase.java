package decorator;

/**
 * Implementación base del Notificador que imprime el mensaje por consola.
 */
public class NotificadorBase implements Notificador {

    /**
     * {@inheritDoc}
     */
    @Override
    public void enviar(String mensaje) {
        System.out.println("[NOTIFICACION] " + mensaje);
    }
}
