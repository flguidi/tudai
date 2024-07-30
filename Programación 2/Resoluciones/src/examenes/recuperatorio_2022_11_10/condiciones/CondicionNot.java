package recuperatorio_2022_11_10.condiciones;

import recuperatorio_2022_11_10.Noticia;

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
