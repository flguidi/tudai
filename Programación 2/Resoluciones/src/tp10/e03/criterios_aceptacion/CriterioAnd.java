package tp10.e03.criterios_aceptacion;

import tp10.e03.Pedido;

public class CriterioAnd extends CriterioAceptacion {
    // Atributos
    private CriterioAceptacion criterio1;
    private CriterioAceptacion criterio2;

    // Constructores
    public CriterioAnd(CriterioAceptacion criterio1, CriterioAceptacion criterio2) {
        this.criterio1 = criterio1;
        this.criterio2 = criterio2;
    }

    // Métodos
    @Override
    public boolean acepta(Pedido pedido) {
        return criterio1.acepta(pedido) && criterio2.acepta(pedido);
    }
}
