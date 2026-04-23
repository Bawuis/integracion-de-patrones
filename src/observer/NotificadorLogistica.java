package observer;

/**
 * Observador que notifica al área de logística sobre cambios de estado del pedido.
 */
public class NotificadorLogistica implements ObservadorPedido {

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizar(String idPedido, String nuevoEstado) {
        System.out.println("[LOGISTICA] Pedido " + idPedido
                + ": requiere acción para estado '" + nuevoEstado + "'");
    }
}
