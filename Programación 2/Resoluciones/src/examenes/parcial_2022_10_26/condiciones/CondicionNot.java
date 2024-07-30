package parcial_2022_10_26.condiciones;

import parcial_2022_10_26.Noticia;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion cond;

    // Constructores
    public CondicionNot(Condicion cond) {
        this.cond = cond;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return !cond.esCumplidaPor(noticia);
    }
}
