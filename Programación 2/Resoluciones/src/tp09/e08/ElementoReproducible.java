package tp09.e08;

import tp09.e08.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class ElementoReproducible {
    // Atributos
    private String titulo;

    // Constructores
    public ElementoReproducible(String titulo) {
        this.titulo = titulo;
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract int getCantidadVideos();

    public abstract int getDuracion();

    public abstract ArrayList<String> getPalabrasClave();

    public abstract ArrayList<Video> buscar(Condicion cond, Comparator<Video> comp);

    @Override
    public String toString() {
        return this.titulo;
    }
}
