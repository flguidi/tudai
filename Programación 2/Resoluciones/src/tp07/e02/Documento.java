package tp07.e02;

import java.util.ArrayList;

public class Documento {
    // Atributos
    private String titulo;
    private String contenido;
    private ArrayList<String> autores;
    private ArrayList<String> palabrasClave;

    // Constructores
    public Documento(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.autores = new ArrayList<>();
        this.palabrasClave = new ArrayList<>();
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void agregarAutor(String autor) {
        autores.add(autor);
    }

    public void eliminarAutor(String autor) {
        autores.remove(autor);
    }

    public boolean tieneAutor(String autor) {
        return autores.contains(autor);
    }

    public void agregarPalabraClave(String palabraClave) {
        if (!palabrasClave.contains(palabraClave))
            palabrasClave.add(palabraClave);
    }

    public void eliminarPalabraClave(String palabraClave) {
        palabrasClave.remove(palabraClave);
    }

    public boolean tienePalabraClave(String palabraClave) {
        return palabrasClave.contains(palabraClave);
    }

    public boolean tienePalabrasClave() {
        return !palabrasClave.isEmpty();
    }

    public String obtenerInformacion() {
        return "INFORMACIÓN DEL DOCUMENTO\n" +
                "Título: " + titulo + "\n" +
                "Contenido: " + contenido + "\n" +
                "Autores: " + autores + "\n" +
                "Palabras clave: " + palabrasClave + "\n";
    }

    @Override
    public String toString() {
        return titulo;
    }
}
