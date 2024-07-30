package tp10.e05.condiciones;

import tp10.e05.ElementoDeCarga;

public class CondicionValorAsegurado extends Condicion {
    // Atributos
    private double valorMinimo;

    // Constructores
    public CondicionValorAsegurado(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoDeCarga paquete) {
        return paquete.getValorAsegurado() > this.valorMinimo;
    }
}
