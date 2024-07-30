package tp09.e02.condiciones;

import tp09.e02.ElementoSA;

public class CondicionTamanio extends Condicion {
    // Atributos
    private double tamanioMinimo;

    // Constructores
    public CondicionTamanio(double tamanioMinimo) {
        this.tamanioMinimo = tamanioMinimo;
    }

    // Métodos
    public boolean esCumplidaPor(ElementoSA elemento) {
        return elemento.getTamanio() > tamanioMinimo;
    }
}
