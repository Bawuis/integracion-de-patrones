package factory;

/**
 * Pedido nacional: entrega dentro del país.
 * Creado exclusivamente por {@link PedidoFactory}.
 */
public class PedidoNacional extends Pedido {

    /**
     * Construye un pedido nacional.
     *
     * @param id           identificador único
     * @param descripcion  descripción del pedido
     * @param pesoKg       peso en kilogramos
     * @param distanciaKm  distancia de entrega en kilómetros
     */
    PedidoNacional(String id, String descripcion, double pesoKg, double distanciaKm) {
        super(id, descripcion, pesoKg, distanciaKm);
    }

    @Override
    public String toString() {
        return "PedidoNacional{id='" + id + "', descripcion='" + descripcion
                + "', pesoKg=" + pesoKg + ", distanciaKm=" + distanciaKm
                + ", estado='" + estado + "'}";
    }
}
