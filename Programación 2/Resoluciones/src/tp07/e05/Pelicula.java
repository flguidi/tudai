package tp07.e05;

import tp07.e05.condiciones.Condicion;
import java.util.ArrayList;

public class Pelicula {
    // Atributos
    private String titulo;
    private String sinopsis;
    private String director;
    private int anioEstreno;
    private int duracionMinutos;
    private int edadMinima;
    private ArrayList<String> generos;
    private ArrayList<String> actores;

    // Constructores
    public Pelicula(String titulo, String sinopsis, String director,
                    int anioEstreno, int duracionMinutos, int edadMinima) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.anioEstreno = anioEstreno;
        this.duracionMinutos = duracionMinutos;
        this.edadMinima = edadMinima;
        this.generos = new ArrayList<>();
        this.actores = new ArrayList<>();
    }

    // Métodos
    public void agregarGenero(String genero) {
        if (!generos.contains(genero))
            generos.add(genero);
    }

    public void eliminarGenero(String genero) {
        actores.remove(genero);
    }

    public boolean tieneGenero(String genero) {
        return generos.contains(genero);
    }

    public void agregarActor(String actor) {
        if (!generos.contains(actor))
            actores.add(actor);
    }

    public void eliminarActor(String actor) {
        generos.remove(actor);
    }

    public boolean tieneActor(String actor) {
        return actores.contains(actor);
    }

    public boolean esRentable(Condicion condicion) {
        return condicion.esCumplidaPor(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String obtenerInformacion() {
        return "PELICULA\n" +
                "Titulo: " + titulo + "\n" +
                "Sinopsis: " + sinopsis + "\n" +
                "Géneros: " + generos + "\n" +
                "Director: " + director + "\n" +
                "Actores: " + actores + "\n" +
                "Año de estreno: " + anioEstreno + "\n" +
                "Duración (minutos): " + duracionMinutos + "\n" +
                "Edad mínima: " + edadMinima;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Pelicula otraPelicula = (Pelicula) o;
            return titulo.equals(otraPelicula.getTitulo()) && director.equals(otraPelicula.getDirector());
        } catch (Exception e) {
            return false;
        }
    }
}
