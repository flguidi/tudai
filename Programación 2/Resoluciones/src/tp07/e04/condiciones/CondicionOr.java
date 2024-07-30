package tp07.e04.condiciones;

import tp07.e04.Ficha;

public class CondicionOr extends Condicion {
    // Atributos
    private Condicion cond1;
    private Condicion cond2;

    // Constructores
    public CondicionOr(Condicion cond1, Condicion cond2) {
        this.cond1 = cond1;
        this.cond2 = cond2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Ficha ficha) {
        return cond1.esCumplidaPor(ficha) || cond2.esCumplidaPor(ficha);
    }
}
