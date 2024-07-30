package tp09.e04;

import tp09.e04.condiciones.Condicion;
import java.util.ArrayList;

public class Noticia extends ElementoPortal {
    // Atributos
    private String titulo;
    private String introduccion;
    private String texto;
    private String autor;
    private String link;
    private ArrayList<String> palabrasClaves;

    // Constructores
    public Noticia(String titulo, String introduccion, String texto, String autor, String link) {
        this.titulo = titulo;
        this.introduccion = introduccion;
        this.texto = texto;
        this.autor = autor;
        this.link = link;
        this.palabrasClaves = new ArrayList<>();
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void agregarPalabraClave(String palabra) {
        if (!palabrasClaves.contains(palabra))
            palabrasClaves.add(palabra);
    }

    public void eliminarPalabraClave(String palabra) {
        palabrasClaves.remove(palabra);
    }

    public boolean tienePalabraClave(String palabraClave) {
        return this.palabrasClaves.contains(palabraClave);
    }

    @Override
    public int contarNoticias() {
        return 1;
    }

    @Override
    public ArrayList<Noticia> buscar(Condicion condicion) {
        ArrayList<Noticia> busqueda = new ArrayList<>();
        if (condicion.esCumplidaPor(this))
            busqueda.add(this);
        return busqueda;
    }

    @Override
    public ArrayList<ElementoPortal> copiar(Condicion condicion) {
        ArrayList<ElementoPortal> resultado = new ArrayList<>();
        if (condicion.esCumplidaPor(this)) {
            ElementoPortal copia = this.copiar();
            resultado.add(copia);
        }
        return resultado;
    }

    @Override
    public ElementoPortal copiar() {
        return new Noticia(titulo, introduccion, texto, autor, link);
    }

    @Override
    public String imprimirLista() {
        return link + "\n";
    }

    @Override
    public String toString() {
        return titulo;
    }
}
