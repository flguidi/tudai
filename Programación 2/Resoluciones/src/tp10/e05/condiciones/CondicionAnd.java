package tp10.e05.condiciones;

import tp10.e05.ElementoDeCarga;

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
    public boolean esCumplidaPor(ElementoDeCarga paquete) {
        return condicion1.esCumplidaPor(paquete) && condicion2.esCumplidaPor(paquete);
    }
}
