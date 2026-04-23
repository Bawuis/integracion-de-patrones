package decorator;

import java.util.Base64;

/**
 * Decorador que cifra el mensaje en Base64 antes de enviarlo.
 */
public class DecoradorCifrado extends DecoradorNotificador {

    /**
     * @param notificador instancia a decorar
     */
    public DecoradorCifrado(Notificador notificador) {
        super(notificador);
    }

    /**
     * Convierte el mensaje a Base64 y delega al notificador envuelto.
     *
     * @param mensaje mensaje original a cifrar y enviar
     */
    @Override
    public void enviar(String mensaje) {
        String mensajeCifrado = Base64.getEncoder().encodeToString(mensaje.getBytes());
        notificador.enviar(mensajeCifrado);
    }
}
