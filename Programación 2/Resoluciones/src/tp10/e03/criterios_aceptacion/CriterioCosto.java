package tp10.e03.criterios_aceptacion;

import tp10.e03.Pedido;

public class CriterioCosto extends CriterioAceptacion {
    // Atributos
    private double costoMaximo;

    // Constructores
    public CriterioCosto(double costoMaximo) {
        this.costoMaximo = costoMaximo;
    }

    // Métodos
    @Override
    public boolean acepta(Pedido pedido) {
        return pedido.getCostoFabricacion() < costoMaximo;
    }
}
