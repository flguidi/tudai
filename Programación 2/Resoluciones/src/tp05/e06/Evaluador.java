package tp05.e06;

import java.util.ArrayList;

public class Evaluador {
    // Atributos
    private String nombre;
    private ArrayList<String> conociminetos;

    // Constructores
    public Evaluador(String nombre) {
        this.nombre = nombre;
        this.conociminetos = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void agregarConocimiento(String conocimiento) {
        if (!this.conociminetos.contains(conocimiento))
            this.conociminetos.add(conocimiento);
    }

    public void eliminarConocimiento(String conocimiento) {
        this.conociminetos.remove(conocimiento);
    }

    public boolean tieneConocimiento(String conocimiento) {
        return this.conociminetos.contains(conocimiento);
    }

    public boolean puedeEvaluar(Trabajo trabajo) {
        return trabajo.puedeSerEvaluadoPor(this);
    }

    @Override
    public String toString() {
        return "|EVALUADOR|\n" +
                "Nombre: " + nombre + "\n" +
                "Conocimientos: "  + conociminetos;
    }
}
