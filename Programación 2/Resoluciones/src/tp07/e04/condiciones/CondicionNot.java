package tp07.e04.condiciones;

import tp07.e04.Ficha;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion cond;

    // Constructores
    public CondicionNot(Condicion cond) {
        this.cond = cond;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Ficha ficha) {
        return !cond.esCumplidaPor(ficha);
    }
}
