package parcial_2022_10_26.condiciones;

import parcial_2022_10_26.Noticia;

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
    public boolean esCumplidaPor(Noticia noticia) {
        return cond1.esCumplidaPor(noticia) || cond2.esCumplidaPor(noticia);
    }
}
