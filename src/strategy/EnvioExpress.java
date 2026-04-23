package strategy;

import singleton.ConfiguracionSistema;

/**
 * Estrategia de envío express (más rápido, mayor costo).
 * Costo = (pesoKg * 2000 + distanciaKm * 100) * (1 + impuesto).
 */
public class EnvioExpress implements EstrategiaEnvio {

    /**
     * {@inheritDoc}
     * Aplica tarifas express con el impuesto configurado en el sistema.
     */
    @Override
    public double calcularCosto(double pesoKg, double distanciaKm) {
        double impuesto = ConfiguracionSistema.getInstance().getImpuesto();
        return (pesoKg * 2000 + distanciaKm * 100) * (1 + impuesto);
    }
}
