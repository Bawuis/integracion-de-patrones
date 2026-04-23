package strategy;

/**
 * Interfaz Strategy para el cálculo del costo de envío.
 * Permite intercambiar algoritmos de cálculo dinámicamente.
 */
public interface EstrategiaEnvio {

    /**
     * Calcula el costo de envío en función del peso y la distancia.
     *
     * @param pesoKg      peso del paquete en kilogramos
     * @param distanciaKm distancia de entrega en kilómetros
     * @return costo total de envío
     */
    double calcularCosto(double pesoKg, double distanciaKm);
}
