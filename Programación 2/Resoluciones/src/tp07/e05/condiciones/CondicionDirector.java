package tp07.e05.condiciones;

import tp07.e05.Pelicula;

public class CondicionDirector extends Condicion {
    // Atributos
    private String director;

    // Constructores
    public CondicionDirector(String director) {
        this.director = director;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Pelicula pelicula) {
        return pelicula.getDirector().equals(director);
    }
}
