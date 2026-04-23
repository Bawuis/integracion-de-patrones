package factory;

/**
 * Fábrica de pedidos. Oculta la lógica de creación de {@link PedidoNacional}
 * e {@link PedidoInternacional}.
 */
public class PedidoFactory {

    private PedidoFactory() {
        // Clase utilitaria, no instanciable
    }

    /**
     * Crea un pedido del tipo indicado.
     *
     * @param tipo        "nacional" o "internacional"
     * @param id          identificador único del pedido
     * @param descripcion descripción del pedido
     * @param pesoKg      peso del paquete en kilogramos
     * @param distanciaKm distancia de entrega en kilómetros
     * @return instancia de {@link Pedido} del tipo solicitado
     * @throws IllegalArgumentException si el tipo no es reconocido
     */
    public static Pedido crearPedido(String tipo, String id, String descripcion,
                                     double pesoKg, double distanciaKm) {
        switch (tipo.toLowerCase()) {
            case "nacional":
                return new PedidoNacional(id, descripcion, pesoKg, distanciaKm);
            case "internacional":
                return new PedidoInternacional(id, descripcion, pesoKg, distanciaKm, "Por definir");
            default:
                throw new IllegalArgumentException("Tipo de pedido desconocido: " + tipo);
        }
    }
}
