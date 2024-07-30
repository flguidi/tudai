package tp10.e03.criterios_aceptacion;

import tp10.e03.Pedido;

public class CriterioGanancia extends CriterioAceptacion {
    // Atributos
    private double gananciaMinima;

    // Constructores
    public CriterioGanancia(double gananciaMinima) {
        this.gananciaMinima = gananciaMinima;
    }

    // Métodos
    @Override
    public boolean acepta(Pedido pedido) {
        return pedido.calcularGanancia() > this.gananciaMinima;
    }
}
