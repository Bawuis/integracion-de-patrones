package factory;

import observer.ObservadorPedido;
import strategy.EstrategiaEnvio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa un pedido en el sistema de entregas.
 * Implementa los roles de Sujeto (Observer) y Contexto (Strategy).
 */
public abstract class Pedido {

    /** Identificador único del pedido. */
    protected String id;

    /** Descripción del pedido. */
    protected String descripcion;

    /** Peso del paquete en kilogramos. */
    protected double pesoKg;

    /** Distancia de entrega en kilómetros. */
    protected double distanciaKm;

    /** Estado actual del pedido. */
    protected String estado;

    /** Lista de observadores suscritos. */
    private final List<ObservadorPedido> observadores = new ArrayList<>();

    /** Estrategia de envío actualmente configurada. */
    private EstrategiaEnvio estrategiaEnvio;

    /**
     * Constructor para subclases.
     *
     * @param id           identificador del pedido
     * @param descripcion  descripción del pedido
     * @param pesoKg       peso en kilogramos
     * @param distanciaKm  distancia de entrega en kilómetros
     */
    protected Pedido(String id, String descripcion, double pesoKg, double distanciaKm) {
        this.id = id;
        this.descripcion = descripcion;
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
        this.estado = "creado";
    }

    /**
     * Cambia el estado del pedido y notifica a todos los observadores.
     *
     * @param nuevoEstado nuevo estado a asignar
     */
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores();
    }

    /**
     * Suscribe un observador para recibir notificaciones de cambios de estado.
     *
     * @param observador observador a suscribir
     */
    public void suscribir(ObservadorPedido observador) {
        observadores.add(observador);
    }

    /**
     * Elimina un observador de la lista de suscripciones.
     *
     * @param observador observador a eliminar
     */
    public void desuscribir(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    /**
     * Notifica a todos los observadores con el estado actual del pedido.
     */
    public void notificarObservadores() {
        for (ObservadorPedido obs : observadores) {
            obs.actualizar(id, estado);
        }
    }

    /**
     * Calcula el costo de envío usando la estrategia configurada.
     *
     * @return costo de envío
     * @throws IllegalStateException si no se ha configurado una estrategia
     */
    public double calcularCostoEnvio() {
        if (estrategiaEnvio == null) {
            throw new IllegalStateException("No se ha configurado una estrategia de envío para el pedido " + id);
        }
        return estrategiaEnvio.calcularCosto(pesoKg, distanciaKm);
    }

    /**
     * Establece la estrategia de envío a usar para calcular el costo.
     *
     * @param estrategiaEnvio nueva estrategia de envío
     */
    public void setEstrategiaEnvio(EstrategiaEnvio estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }

    /** @return identificador del pedido */
    public String getId() {
        return id;
    }

    /** @return descripción del pedido */
    public String getDescripcion() {
        return descripcion;
    }

    /** @return peso en kilogramos */
    public double getPesoKg() {
        return pesoKg;
    }

    /** @return distancia de entrega en kilómetros */
    public double getDistanciaKm() {
        return distanciaKm;
    }

    /** @return estado actual del pedido */
    public String getEstado() {
        return estado;
    }
}
