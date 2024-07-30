package tp10.e03;

import tp10.e03.comparadores.*;
import tp10.e03.criterios_aceptacion.CriterioAceptacion;
import java.util.Comparator;

public class Fabrica {
    // Atributos
    private ColaPedidos colaPedidos;
    private CriterioAceptacion criterioAceptacion;
    private Comparator<Pedido> criterioOrdenamiento;

    // Constructores
    public Fabrica() {
        this.colaPedidos = new ColaPedidos();
        this.criterioAceptacion = null;
        this.criterioOrdenamiento = new ComparadorGanancia(); // Por defecto
    }

    // Métodos
    public void agregarPedido(Pedido pedido) {
        if (this.criterioAceptacion != null && this.aceptaPedido(pedido))
            this.colaPedidos.agregar(pedido, this.criterioOrdenamiento);
    }

    public Pedido entregarPedido() {
        return this.colaPedidos.extraer();
    }

    public void eliminarPedido(Pedido pedido) {
        this.colaPedidos.eliminar(pedido);
    }

    public boolean aceptaPedido(Pedido pedido) {
        return this.criterioAceptacion.acepta(pedido);
    }

    public void setCriterioAceptacion(CriterioAceptacion criterio) {
        this.criterioAceptacion = criterio;
    }

    public void setCriterioOrdenamiento(Comparator<Pedido> comparador) {
        this.criterioOrdenamiento = comparador;
        this.colaPedidos.ordenar(comparador);
    }

    public double calcularGananciaTotal() {
        return this.colaPedidos.calcularGananciaTotal();
    }

    public String listarPedidos() {
        return this.colaPedidos.listar();
    }
}
