package tp09.e06.condiciones;

import tp09.e06.ElementoSimple;

public class CondicionOr extends Condicion {
    // Atributos
    private Condicion condicion1;
    private Condicion condicion2;

    // Constructores
    public CondicionOr(Condicion condicion1, Condicion condicion2) {
        this.condicion1 = condicion1;
        this.condicion2 = condicion2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSimple elemento) {
        return condicion1.esCumplidaPor(elemento) || condicion2.esCumplidaPor(elemento);
    }
}
