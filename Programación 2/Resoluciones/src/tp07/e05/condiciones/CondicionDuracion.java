package tp07.e05.condiciones;

import tp07.e05.Pelicula;

public class CondicionDuracion extends Condicion {
    // Atributos
    private int duracionLimite;

    // Constructores
    public CondicionDuracion(int duracionLimite) {
        this.duracionLimite = duracionLimite;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Pelicula pelicula) {
        return pelicula.getDuracionMinutos() < duracionLimite;
    }
}
