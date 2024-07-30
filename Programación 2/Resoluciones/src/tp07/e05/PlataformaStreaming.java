package tp07.e05;

import tp07.e05.condiciones.Condicion;
import java.util.ArrayList;

public class PlataformaStreaming {
    // Atributos
    private ArrayList<Pelicula> peliculas;

    // Constructores
    public PlataformaStreaming() {
        this.peliculas = new ArrayList<>();
    }

    // Métodos
    public void agregarPelicula(Pelicula pelicula) {
        if (!peliculas.contains(pelicula))
            peliculas.add(pelicula);
    }

    public void eliminarPelicula(Pelicula pelicula) {
        peliculas.remove(pelicula);
    }

    public ArrayList<Pelicula> buscarPeliculas(Condicion condicion) {
        ArrayList<Pelicula> lista = new ArrayList<>();
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula pelicula = peliculas.get(i);
            if (condicion.esCumplidaPor(pelicula))
                lista.add(pelicula);
        }
        return lista;
    }
}
