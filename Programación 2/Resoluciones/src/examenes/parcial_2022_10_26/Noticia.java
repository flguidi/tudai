package parcial_2022_10_26;

import parcial_2022_10_26.condiciones.Condicion;
import java.util.ArrayList;

public class Noticia extends ElementoPortal {
    // Atributos
    private String titulo;
    private String autor;
    private String contenido;
    private String categoria;
    private ArrayList<String> palabrasClaves;

    // Constructores
    public Noticia(String titulo, String autor, String contenido, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
        this.categoria = categoria;
        this.palabrasClaves = new ArrayList<>();
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void agregarPalabraClave(String palabra) {
        if (!palabrasClaves.contains(palabra))
            palabrasClaves.add(palabra);
    }

    public void agregarPalabraClave(String palabra, Condicion condicion) {
        if (condicion.esCumplidaPor(this))
            this.agregarPalabraClave(palabra);
    }

    public void eliminarPalabraClave(String palabra) {
        palabrasClaves.remove(palabra);
    }

    @Override
    public ArrayList<String> obtenerPalabrasClaves() {
        return new ArrayList<>(palabrasClaves);
    }

    @Override
    public ArrayList<Noticia> filtrar(Condicion condicion) {
        ArrayList<Noticia> resultado = new ArrayList<>();
        if (condicion.esCumplidaPor(this))
            resultado.add(this);
        return resultado;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
