package tp10.e01.criterios_aceptacion;

import tp10.e01.OfertaLaboral;

public class CriterioExclusividad extends CriterioAceptacion {
    // Atributos
    private String empresa;

    // Constructores
    public CriterioExclusividad(String empresa) {
        this.empresa = empresa;
    }

    // Métodos
    @Override
    public boolean acepta(OfertaLaboral oferta) {
        return empresa == null;
    }
}
