package recuperatorio_2022_11_10;

import recuperatorio_2022_11_10.condiciones.Condicion;
import java.util.ArrayList;

public class Noticia extends ElementoPortal {
    // Atributos
    private String titulo;
    private String autor;
    private String contenido;
    private ArrayList<String> palabrasClaves;

    // Constructores
    public Noticia(String categoria, String titulo, String autor, String contenido) {
        super(categoria);
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
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

    public void agregarPalabraClave(String palabra) {
        if (!palabrasClaves.contains(palabra))
            palabrasClaves.add(palabra);
    }

    public void eliminarPalabraClave(String palabra) {
        palabrasClaves.remove(palabra);
    }

    public boolean tienePalabraClave(String palabra) {
        return palabrasClaves.contains(palabra);
    }

    @Override
    public ArrayList<String> obtenerPalabrasClaves() {
        return new ArrayList<>(palabrasClaves);
    }

    @Override
    public ElementoPortal copiar(Condicion condicion) {
        if (condicion.esCumplidaPor(this)) {
            Noticia copia = new Noticia(getCategoria(), this.getTitulo(), this.getAutor(), this.getContenido());
            for (int i = 0; i < palabrasClaves.size(); i++)
                copia.agregarPalabraClave(palabrasClaves.get(i));
            return copia;
        }
        return null;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
