import decorator.DecoradorCifrado;
import decorator.DecoradorLogging;
import decorator.Notificador;
import decorator.NotificadorBase;
import factory.Pedido;
import factory.PedidoFactory;
import observer.NotificadorCliente;
import observer.NotificadorLogistica;
import singleton.ConfiguracionSistema;
import strategy.EnvioEstandar;
import strategy.EnvioExpress;
import strategy.EnvioProgramado;

/**
 * Clase principal que demuestra el flujo completo del sistema de entregas,
 * integrando los patrones Singleton, Factory, Observer, Strategy y Decorator.
 */
public class Main {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) throws InterruptedException {

        // ----------------------------------------------------------------
        // 1. Singleton – Configuración global del sistema
        // ----------------------------------------------------------------
        System.out.println("=== CONFIGURACION DEL SISTEMA ===");
        ConfiguracionSistema config = ConfiguracionSistema.getInstance();
        System.out.println("Impuesto : " + config.getImpuesto());
        System.out.println("Moneda   : " + config.getMoneda());
        System.out.println("Descuento: " + config.getDescuento());
        System.out.println();

        // ----------------------------------------------------------------
        // 2. Factory – Crear pedidos sin usar new directamente
        // ----------------------------------------------------------------
        System.out.println("=== CREACION DE PEDIDOS ===");
        Pedido pedidoNacional = PedidoFactory.crearPedido(
                "nacional", "P001", "Electrodomestico", 5.0, 100.0);
        Pedido pedidoInternacional = PedidoFactory.crearPedido(
                "internacional", "P002", "Repuesto automotriz", 2.5, 3000.0);
        System.out.println("Creado: " + pedidoNacional);
        System.out.println("Creado: " + pedidoInternacional);
        System.out.println();

        // ----------------------------------------------------------------
        // 3. Observer – Suscribir observadores al pedido nacional
        // ----------------------------------------------------------------
        System.out.println("=== SUSCRIPCION DE OBSERVADORES ===");
        NotificadorCliente notifCliente = new NotificadorCliente();
        NotificadorLogistica notifLogistica = new NotificadorLogistica();
        pedidoNacional.suscribir(notifCliente);
        pedidoNacional.suscribir(notifLogistica);
        System.out.println("Observadores suscritos al pedido " + pedidoNacional.getId());
        System.out.println();

        // ----------------------------------------------------------------
        // 4. Strategy – Calcular costo con EnvioEstandar y luego EnvioExpress
        // ----------------------------------------------------------------
        System.out.println("=== CALCULO DE COSTO DE ENVIO ===");
        pedidoNacional.setEstrategiaEnvio(new EnvioEstandar());
        System.out.printf("Costo Estandar  : %.2f %s%n",
                pedidoNacional.calcularCostoEnvio(), config.getMoneda());

        pedidoNacional.setEstrategiaEnvio(new EnvioExpress());
        System.out.printf("Costo Express   : %.2f %s%n",
                pedidoNacional.calcularCostoEnvio(), config.getMoneda());

        pedidoNacional.setEstrategiaEnvio(new EnvioProgramado());
        System.out.printf("Costo Programado: %.2f %s%n",
                pedidoNacional.calcularCostoEnvio(), config.getMoneda());
        System.out.println();

        // ----------------------------------------------------------------
        // 5. Observer – Cambios de estado: creado → en preparación → enviado → entregado
        // ----------------------------------------------------------------
        System.out.println("=== CAMBIOS DE ESTADO DEL PEDIDO NACIONAL ===");
        pedidoNacional.cambiarEstado("en preparación");
        pedidoNacional.cambiarEstado("enviado");
        pedidoNacional.cambiarEstado("entregado");
        System.out.println();

        // ----------------------------------------------------------------
        // 6. Decorator – Notificador decorado con Logging y Cifrado
        // ----------------------------------------------------------------
        System.out.println("=== NOTIFICADOR DECORADO (Logging + Cifrado) ===");
        Notificador notificador = new DecoradorLogging(
                new DecoradorCifrado(
                        new NotificadorBase()));
        notificador.enviar("Pedido P001 entregado exitosamente");
    }
}
