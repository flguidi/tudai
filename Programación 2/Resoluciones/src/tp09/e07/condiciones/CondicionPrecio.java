package tp09.e07.condiciones;

import tp09.e07.ElementoBazar;

public class CondicionPrecio extends Condicion {
    // Atributos
    private double precioMaximo;

    // Constructores
    public CondicionPrecio(double precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoBazar elemento) {
        return elemento.getPrecio() < this.precioMaximo;
    }
}
