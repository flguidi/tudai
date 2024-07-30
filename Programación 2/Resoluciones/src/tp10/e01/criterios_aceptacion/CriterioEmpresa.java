package tp10.e01.criterios_aceptacion;

import tp10.e01.OfertaLaboral;

public class CriterioEmpresa extends CriterioAceptacion {
    // Atributos
    private String empresa;

    // Constructores
    public CriterioEmpresa(String empresa) {
        this.empresa = empresa;
    }

    // Métodos
    @Override
    public boolean acepta(OfertaLaboral oferta) {
        return !oferta.getEmpresa().equals(this.empresa);
    }
}
