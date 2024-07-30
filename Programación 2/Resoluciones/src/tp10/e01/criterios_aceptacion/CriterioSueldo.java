package tp10.e01.criterios_aceptacion;

import tp10.e01.OfertaLaboral;

public class CriterioSueldo extends CriterioAceptacion {
    // Atributos
    private double sueldo;

    // Constructores
    public CriterioSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    // Métodos
    @Override
    public boolean acepta(OfertaLaboral oferta) {
        return oferta.getMontoOfrecido() >= this.sueldo;
    }
}
