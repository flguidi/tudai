package tp09.e01.condiciones;

import tp09.e01.Socio;

public class CondicionPago extends Condicion {
    // Atributos
    private double precioMinimo;

    // Constructores
    public CondicionPago(double pagoLimite) {
        this.precioMinimo = pagoLimite;
    }

    // Métodos
    public boolean esCumplidaPor(Socio socio) {
        return socio.pagoMasQue(precioMinimo);
    }
}
