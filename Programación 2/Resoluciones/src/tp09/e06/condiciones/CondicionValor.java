package tp09.e06.condiciones;

import tp09.e06.ElementoSimple;

public class CondicionValor extends Condicion {
    // Atributos
    private double valorMaximo;

    // Constructores
    public CondicionValor(double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSimple seguro) {
        return seguro.getValor() < valorMaximo;
    }
}
