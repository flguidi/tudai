package tp09.e04.condiciones;

import tp09.e04.Noticia;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion condicion;

    // Constructores
    public CondicionNot(Condicion condicion) {
        this.condicion = condicion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return !condicion.esCumplidaPor(noticia);
    }
}
