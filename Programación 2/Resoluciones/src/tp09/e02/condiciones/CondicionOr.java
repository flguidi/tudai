package tp09.e02.condiciones;

import tp09.e02.ElementoSA;

public class CondicionOr extends Condicion {
    // Atributos
    private Condicion f1;
    private Condicion f2;

    // Constructores
    public CondicionOr(Condicion f1, Condicion f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSA elemento) {
        return f1.esCumplidaPor(elemento) || f2.esCumplidaPor(elemento);
    }
}
