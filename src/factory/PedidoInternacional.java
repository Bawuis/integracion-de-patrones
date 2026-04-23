package factory;

/**
 * Pedido internacional: entrega a otro país.
 * Incluye el atributo adicional {@code paisDestino}.
 * Creado exclusivamente por {@link PedidoFactory}.
 */
public class PedidoInternacional extends Pedido {

    /** País de destino del pedido. */
    private String paisDestino;

    /**
     * Construye un pedido internacional.
     *
     * @param id           identificador único
     * @param descripcion  descripción del pedido
     * @param pesoKg       peso en kilogramos
     * @param distanciaKm  distancia de entrega en kilómetros
     * @param paisDestino  país de destino
     */
    PedidoInternacional(String id, String descripcion, double pesoKg,
                        double distanciaKm, String paisDestino) {
        super(id, descripcion, pesoKg, distanciaKm);
        this.paisDestino = paisDestino;
    }

    /** @return país de destino */
    public String getPaisDestino() {
        return paisDestino;
    }

    /** @param paisDestino nuevo país de destino */
    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    @Override
    public String toString() {
        return "PedidoInternacional{id='" + id + "', descripcion='" + descripcion
                + "', pesoKg=" + pesoKg + ", distanciaKm=" + distanciaKm
                + ", estado='" + estado + "', paisDestino='" + paisDestino + "'}";
    }
}
