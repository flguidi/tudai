package tp07.e01.condiciones;

import tp07.e01.Agroquimico;

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
    public boolean esCumplidaPor(Agroquimico agroquimico) {
        return cond1.esCumplidaPor(agroquimico) && cond2.esCumplidaPor(agroquimico);
    }
}
