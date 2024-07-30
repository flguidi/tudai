package tp09.e07.condiciones;

import tp09.e07.ElementoBazar;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion condicion;

    // Constructores
    public CondicionNot(Condicion condicion) {
        this.condicion = condicion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoBazar elemento) {
        return !condicion.esCumplidaPor(elemento);
    }
}
