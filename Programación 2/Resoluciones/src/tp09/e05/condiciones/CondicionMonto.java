package tp09.e05.condiciones;

import tp09.e05.SeguroSimple;

public class CondicionMonto extends Condicion {
    // Atributos
    private double montoMinimo;

    // Constructores
    public CondicionMonto(double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(SeguroSimple seguro) {
        return seguro.getMontoAsegurado() > montoMinimo;
    }
}
