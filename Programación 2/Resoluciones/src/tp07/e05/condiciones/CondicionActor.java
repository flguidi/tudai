package tp07.e05.condiciones;

import tp07.e05.Pelicula;

public class CondicionActor extends Condicion {
    // Atributos
    private String actor;

    // Constructores
    public CondicionActor(String actor) {
        this.actor = actor;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Pelicula pelicula) {
        return pelicula.tieneActor(actor);
    }
}
