package tp07.e05.condiciones;

import tp07.e05.Pelicula;

public class CondicionGenero extends Condicion {
    // Atributos
    private String genero;

    // Constructores
    public CondicionGenero(String genero) {
        this.genero = genero;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Pelicula pelicula) {
        return pelicula.tieneGenero(genero);
    }
}
