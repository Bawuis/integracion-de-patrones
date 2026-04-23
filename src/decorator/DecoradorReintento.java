package decorator;

/**
 * Decorador que reintenta el envío hasta 3 veces en caso de excepción,
 * esperando 500 ms entre cada intento.
 */
public class DecoradorReintento extends DecoradorNotificador {

    private static final int MAX_INTENTOS = 3;

    /**
     * @param notificador instancia a decorar
     */
    public DecoradorReintento(Notificador notificador) {
        super(notificador);
    }

    /**
     * Intenta enviar el mensaje hasta {@value #MAX_INTENTOS} veces.
     * Espera 500 ms entre intentos fallidos.
     *
     * @param mensaje mensaje a enviar
     */
    @Override
    public void enviar(String mensaje) {
        for (int intento = 1; intento <= MAX_INTENTOS; intento++) {
            try {
                notificador.enviar(mensaje);
                return;
            } catch (Exception e) {
                System.out.println("[REINTENTO] Intento " + intento + " fallido: " + e.getMessage());
                if (intento < MAX_INTENTOS) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        System.out.println("[REINTENTO] No se pudo enviar la notificación tras " + MAX_INTENTOS + " intentos.");
    }
}
