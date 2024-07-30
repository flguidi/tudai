package tp10.e03.criterios_aceptacion;

import tp10.e03.Pedido;

public class CriterioNot extends CriterioAceptacion {
    // Atributos
    private CriterioAceptacion criterio;

    // Constructores
    public CriterioNot(CriterioAceptacion criterio) {
        this.criterio = criterio;
    }

    // Métodos
    @Override
    public boolean acepta(Pedido pedido) {
        return !this.criterio.acepta(pedido);
    }
}
