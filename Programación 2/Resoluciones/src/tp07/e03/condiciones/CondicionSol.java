package tp07.e03.condiciones;

import tp07.e03.Planta;

public class CondicionSol extends Condicion {
    // Atributos
    private int solMinimo;

    // Constructores
    public CondicionSol(int solMinimo) {
        this.solMinimo = solMinimo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Planta planta) {
        return planta.getSolRequerido() > solMinimo;
    }
}
