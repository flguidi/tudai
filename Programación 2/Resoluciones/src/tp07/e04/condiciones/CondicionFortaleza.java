package tp07.e04.condiciones;

import tp07.e04.Ficha;

public class CondicionFortaleza extends Condicion {
    // Atributos
    private double fortaleza;

    // Constructores
    public CondicionFortaleza(double fortaleza) {
        this.fortaleza = fortaleza;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Ficha ficha) {
        return ficha.getFortaleza() > fortaleza;
    }
}
