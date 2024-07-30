package tp09.e02.condiciones;

import tp09.e02.ElementoSA;

public class CondicionAnd extends Condicion {
    // Atributos
    private Condicion cond1;
    private Condicion cond2;

    // Constructores
    public CondicionAnd(Condicion cond1, Condicion cond2) {
        this.cond1 = cond1;
        this.cond2 = cond2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSA elemento) {
        return cond1.esCumplidaPor(elemento) && cond2.esCumplidaPor(elemento);
    }
}
