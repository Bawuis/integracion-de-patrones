package decorator;

/**
 * Clase abstracta base del patrón Decorator.
 * Envuelve un {@link Notificador} y delega la llamada a {@code enviar}.
 */
public abstract class DecoradorNotificador implements Notificador {

    /** Notificador envuelto. */
    protected final Notificador notificador;

    /**
     * @param notificador instancia a decorar (no puede ser null)
     * @throws IllegalArgumentException si notificador es null
     */
    public DecoradorNotificador(Notificador notificador) {
        if (notificador == null) {
            throw new IllegalArgumentException("El notificador no puede ser null");
        }
        this.notificador = notificador;
    }

    /**
     * {@inheritDoc}
     * Delega al notificador envuelto por defecto.
     */
    @Override
    public void enviar(String mensaje) {
        notificador.enviar(mensaje);
    }
}
