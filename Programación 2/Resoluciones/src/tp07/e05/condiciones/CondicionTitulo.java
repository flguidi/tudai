package tp07.e05.condiciones;

import tp07.e05.Pelicula;

public class CondicionTitulo extends Condicion {
    // Atributos
    private String titulo;

    // Constructores
    public CondicionTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Pelicula pelicula) {
        return pelicula.getTitulo().contains(titulo);
    }
}
