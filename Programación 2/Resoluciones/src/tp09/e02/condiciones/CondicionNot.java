package tp09.e02.condiciones;

import tp09.e02.ElementoSA;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion cond;

    // Constructores
    public CondicionNot(Condicion cond) {
        this.cond = cond;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSA elemento) {
        return !cond.esCumplidaPor(elemento);
    }
}
