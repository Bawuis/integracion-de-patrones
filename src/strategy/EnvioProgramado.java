package strategy;

import singleton.ConfiguracionSistema;

/**
 * Estrategia de envío programado (con descuento, menor costo).
 * Costo = (pesoKg * 800 + distanciaKm * 40) * (1 - descuento) * (1 + impuesto).
 */
public class EnvioProgramado implements EstrategiaEnvio {

    /**
     * {@inheritDoc}
     * Aplica tarifas programadas con descuento e impuesto del sistema.
     */
    @Override
    public double calcularCosto(double pesoKg, double distanciaKm) {
        double impuesto = ConfiguracionSistema.getInstance().getImpuesto();
        double descuento = ConfiguracionSistema.getInstance().getDescuento();
        return (pesoKg * 800 + distanciaKm * 40) * (1 - descuento) * (1 + impuesto);
    }
}
