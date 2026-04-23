package observer;

/**
 * Observador que notifica al cliente sobre cambios de estado del pedido.
 */
public class NotificadorCliente implements ObservadorPedido {

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizar(String idPedido, String nuevoEstado) {
        System.out.println("[CLIENTE] Pedido " + idPedido
                + ": estado actualizado a '" + nuevoEstado + "'");
    }
}
