package singleton;

/**
 * Singleton que centraliza la configuración global del sistema de entregas.
 * Solo puede existir una única instancia en todo el sistema.
 */
public class ConfiguracionSistema {

    private static ConfiguracionSistema instancia;

    private double impuesto;
    private String moneda;
    private double descuento;

    /** Constructor privado para evitar instanciación directa. */
    private ConfiguracionSistema() {
        this.impuesto = 0.19;
        this.moneda = "COP";
        this.descuento = 0.05;
    }

    /**
     * Retorna la única instancia de ConfiguracionSistema (thread-safe).
     *
     * @return instancia única
     */
    public static synchronized ConfiguracionSistema getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    /** @return tasa de impuesto (ej. 0.19 = 19%) */
    public double getImpuesto() {
        return impuesto;
    }

    /** @param impuesto nueva tasa de impuesto (debe estar entre 0.0 y 1.0) */
    public void setImpuesto(double impuesto) {
        if (impuesto < 0.0 || impuesto > 1.0) {
            throw new IllegalArgumentException("El impuesto debe estar entre 0.0 y 1.0");
        }
        this.impuesto = impuesto;
    }

    /** @return moneda del sistema (ej. "COP") */
    public String getMoneda() {
        return moneda;
    }

    /** @param moneda nueva moneda */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /** @return porcentaje de descuento (ej. 0.05 = 5%) */
    public double getDescuento() {
        return descuento;
    }

    /** @param descuento nuevo porcentaje de descuento (debe estar entre 0.0 y 1.0) */
    public void setDescuento(double descuento) {
        if (descuento < 0.0 || descuento > 1.0) {
            throw new IllegalArgumentException("El descuento debe estar entre 0.0 y 1.0");
        }
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "ConfiguracionSistema{impuesto=" + impuesto
                + ", moneda='" + moneda + "', descuento=" + descuento + "}";
    }
}
