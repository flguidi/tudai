package tp05.e06;

import java.util.ArrayList;

public class Comite {
    // Atributos
    private ArrayList<Evaluador> evaluadores;
    private ArrayList<Trabajo> trabajos;

    // Constructores
    public Comite() {
        this.evaluadores = new ArrayList<>();
        this.trabajos = new ArrayList<>();
    }

    // Métodos
    public void agregarEvaluador(Evaluador evaluador) {
        if (!this.evaluadores.contains(evaluador))
            this.evaluadores.add(evaluador);
    }

    public void eliminarEvaluador(Evaluador evaluador) {
        this.evaluadores.remove(evaluador);
    }

    public void agregarTrabajo(Trabajo trabajo) {
        if (!this.trabajos.contains(trabajo))
            this.trabajos.add(trabajo);
    }

    public void eliminarTrabajo(Trabajo trabajo) {
        this.trabajos.remove(trabajo);
    }
}
