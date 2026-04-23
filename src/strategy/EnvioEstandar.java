package strategy;

import singleton.ConfiguracionSistema;

/**
 * Estrategia de envío estándar.
 * Costo = (pesoKg * 1000 + distanciaKm * 50) * (1 + impuesto).
 */
public class EnvioEstandar implements EstrategiaEnvio {

    /**
     * {@inheritDoc}
     * Aplica tarifas estándar con el impuesto configurado en el sistema.
     */
    @Override
    public double calcularCosto(double pesoKg, double distanciaKm) {
        double impuesto = ConfiguracionSistema.getInstance().getImpuesto();
        return (pesoKg * 1000 + distanciaKm * 50) * (1 + impuesto);
    }
}
