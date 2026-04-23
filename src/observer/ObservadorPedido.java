package observer;

/**
 * Interfaz Observer para notificaciones de cambios de estado de un pedido.
 */
public interface ObservadorPedido {

    /**
     * Se invoca cuando el estado del pedido cambia.
     *
     * @param idPedido    identificador del pedido
     * @param nuevoEstado nuevo estado del pedido
     */
    void actualizar(String idPedido, String nuevoEstado);
}
