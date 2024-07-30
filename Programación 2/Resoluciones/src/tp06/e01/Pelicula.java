package tp06.e01;

import java.time.LocalDate;

public class Pelicula extends Producto {
    // Atributos
    private String titulo;
    private String director;
    private int numeroCopias;

    // Constructores
    public Pelicula(String titulo, String director, int numeroCopias, LocalDate vencimientoAlquiler) {
        super(vencimientoAlquiler);
        this.titulo = titulo;
        this.director = director;
        this.numeroCopias = numeroCopias;
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean sePuedeAlquilarA(Cliente cliente) {
        return numeroCopias > 0;
    }

    @Override
    public void alquilarA(Cliente cliente) {
        cliente.agregarProductoAlquilado(this);
        numeroCopias--;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
