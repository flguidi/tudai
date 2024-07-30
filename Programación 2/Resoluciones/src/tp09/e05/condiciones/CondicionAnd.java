package tp09.e05.condiciones;

import tp09.e05.SeguroSimple;

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
    public boolean esCumplidaPor(SeguroSimple seguro) {
        return condicion1.esCumplidaPor(seguro) && condicion2.esCumplidaPor(seguro);
    }
}
