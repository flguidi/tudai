package recuperatorio_2022_11_10.condiciones;

import recuperatorio_2022_11_10.Noticia;

public class CondicionAnd extends Condicion {
    // Atributos
    private Condicion cond1;
    private Condicion cond2;

    // Constructor
    public CondicionAnd(Condicion cond1, Condicion cond2) {
        this.cond1 = cond1;
        this.cond2 = cond2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return cond1.esCumplidaPor(noticia) && cond2.esCumplidaPor(noticia);
    }
}
