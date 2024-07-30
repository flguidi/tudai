package tp07.e02.condiciones;

import tp07.e02.Documento;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion cond;

    // Constructores
    public CondicionNot(Condicion cond) {
        this.cond = cond;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Documento documento) {
        return !cond.esCumplidaPor(documento);
    }
}
