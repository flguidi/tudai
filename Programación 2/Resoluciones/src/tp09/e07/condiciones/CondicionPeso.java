package tp09.e07.condiciones;

import tp09.e07.ElementoBazar;

public class CondicionPeso extends Condicion {
    // Atributos
    private double pesoMinimo;

    // Constructores
    public CondicionPeso(double pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoBazar elemento) {
        return elemento.getPeso() > this.pesoMinimo;
    }
}
