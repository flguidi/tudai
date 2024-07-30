package tp09.e06.condiciones;

import tp09.e06.ElementoSimple;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion condicion;

    // Constructores
    public CondicionNot(Condicion condicion) {
        this.condicion = condicion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSimple elemento) {
        return !condicion.esCumplidaPor(elemento);
    }
}
