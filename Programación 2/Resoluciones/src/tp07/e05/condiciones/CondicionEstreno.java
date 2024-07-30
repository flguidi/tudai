package tp07.e05.condiciones;

import tp07.e05.Pelicula;

public class CondicionEstreno extends Condicion {
    // Atributos
    private int anioLimite;

    // Constructores
    public CondicionEstreno(int anioLimite) {
        this.anioLimite = anioLimite;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Pelicula pelicula) {
        return pelicula.getAnioEstreno() < anioLimite;
    }
}
