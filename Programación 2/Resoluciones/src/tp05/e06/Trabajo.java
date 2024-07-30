package tp05.e06;

import java.util.ArrayList;

public class Trabajo {
    // Atributos
    private String titulo;
    private String tipo;
    protected ArrayList<String> palabrasClaves;

    // Constructores
    public Trabajo(String titulo, String tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.palabrasClaves = new ArrayList<>();
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean puedeSerEvaluadoPor(Evaluador evaluador) {
        for (String palabraClave : this.palabrasClaves) {
            if (!evaluador.tieneConocimiento(palabraClave))
                return false;
        }
        return true;
    }

    public void agregarPalabraClave(String palabraClave) {
        if (!this.palabrasClaves.contains(palabraClave))
            this.palabrasClaves.add(palabraClave);
    }

    public void eliminarPalabraClave(String palabraClave) {
        this.palabrasClaves.remove(palabraClave);
    }

    public boolean tienePalabraClave(String palabra) {
        return this.palabrasClaves.contains(palabra);
    }

    @Override
    public String toString() {
        return "|TRABAJO|\n" +
                "Título: " + titulo + "\n" +
                "Tipo: " + tipo + "\n" +
                "Palabras claves: " + palabrasClaves;
    }
}
