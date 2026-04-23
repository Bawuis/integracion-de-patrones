package decorator;

/**
 * Decorador que agrega logging antes de enviar la notificación.
 */
public class DecoradorLogging extends DecoradorNotificador {

    /**
     * @param notificador instancia a decorar
     */
    public DecoradorLogging(Notificador notificador) {
        super(notificador);
    }

    /**
     * Imprime un mensaje de log y luego delega al notificador envuelto.
     *
     * @param mensaje mensaje a enviar
     */
    @Override
    public void enviar(String mensaje) {
        System.out.println("[LOG] Enviando notificación: " + mensaje);
        notificador.enviar(mensaje);
    }
}
