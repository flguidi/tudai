package tp07.e05.condiciones;

import tp07.e05.Pelicula;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion cond;

    // Constructores
    public CondicionNot(Condicion cond) {
        this.cond = cond;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Pelicula pelicula) {
        return !cond.esCumplidaPor(pelicula);
    }
}
