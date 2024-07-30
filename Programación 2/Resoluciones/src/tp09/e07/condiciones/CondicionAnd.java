package tp09.e07.condiciones;

import tp09.e07.ElementoBazar;

public class CondicionAnd extends Condicion {
    // Atributos
    private Condicion condicion1;
    private Condicion condicion2;

    // Constructores
    public CondicionAnd(Condicion condicion1, Condicion condicion2) {
        this.condicion1 = condicion1;
        this.condicion2 = condicion2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoBazar elemento) {
        return condicion1.esCumplidaPor(elemento) && condicion2.esCumplidaPor(elemento);
    }
}
