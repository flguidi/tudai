package tp07.e03.condiciones;

import tp07.e03.Planta;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion cond;

    // Constructores
    public CondicionNot(Condicion cond) {
        this.cond = cond;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Planta planta) {
        return !cond.esCumplidaPor(planta);
    }
}
