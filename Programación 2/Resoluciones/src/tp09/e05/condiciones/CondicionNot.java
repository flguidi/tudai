package tp09.e05.condiciones;

import tp09.e05.SeguroSimple;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion condicion;

    // Constructores
    public CondicionNot(Condicion condicion) {
        this.condicion = condicion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(SeguroSimple seguro) {
        return !condicion.esCumplidaPor(seguro);
    }
}
