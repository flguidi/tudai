package tp10.e05.condiciones;

import tp10.e05.ElementoDeCarga;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion condicion;

    // Constructores
    public CondicionNot(Condicion condicion) {
        this.condicion = condicion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoDeCarga paquete) {
        return !condicion.esCumplidaPor(paquete);
    }
}
