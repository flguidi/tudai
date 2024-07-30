package tp10.e03.criterios_aceptacion;

import tp10.e03.Pedido;

public class CriterioCaracteristica extends CriterioAceptacion {
    // Atributos
    private String caracteristica;

    // Constructores
    public CriterioCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    // Métodos
    @Override
    public boolean acepta(Pedido pedido) {
        return pedido.tieneCaracteristica(this.caracteristica);
    }
}
