package tp09.e04.condiciones;

import tp09.e04.Noticia;

public class CondicionOr extends Condicion {
    // Atributos
    private Condicion condicion1;
    private Condicion condicion2;

    // Constructores
    public CondicionOr(Condicion condicion1, Condicion condicion2) {
        this.condicion1 = condicion1;
        this.condicion2 = condicion2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return condicion1.esCumplidaPor(noticia) || condicion2.esCumplidaPor(noticia);
    }
}
