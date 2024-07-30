package tp07.e04.condiciones;

import tp07.e04.Ficha;

public class CondicionPoder extends Condicion {
    // Atributos
    private double poderDestruccion;

    // Constructores
    public CondicionPoder(double poderDestruccion) {
        this.poderDestruccion = poderDestruccion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Ficha ficha) {
        return ficha.getPoderDestruccion() > poderDestruccion;
    }
}
