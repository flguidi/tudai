package tp10.e04.condiciones;

import tp10.e04.Gasto;

public class CondicionMonto<T> extends Condicion<T> {
    // Atributos
    private double montoMinimo;

    // Constructores
    public CondicionMonto(double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Gasto<T> gasto) {
        return gasto.getMonto() > this.montoMinimo;
    }
}
