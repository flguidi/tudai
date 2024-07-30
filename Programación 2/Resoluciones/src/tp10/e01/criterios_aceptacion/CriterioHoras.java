package tp10.e01.criterios_aceptacion;

import tp10.e01.OfertaLaboral;

public class CriterioHoras extends CriterioAceptacion {
    // Atributos
    private int maxHoras;

    // Constructores
    public CriterioHoras(int maxHoras) {
        this.maxHoras = maxHoras;
    }

    // Métodos
    @Override
    public boolean acepta(OfertaLaboral oferta) {
        return oferta.getHorasSemanales() <= maxHoras;
    }
}
