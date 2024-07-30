package tp07.e03.condiciones;

import tp07.e03.Planta;

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
    public boolean esCumplidaPor(Planta planta) {
        return cond1.esCumplidaPor(planta) && cond2.esCumplidaPor(planta);
    }
}
