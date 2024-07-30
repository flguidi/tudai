package tp10.e05.condiciones;

import tp10.e05.ElementoDeCarga;

public class CondicionPrecioEnvio extends Condicion {
    // Atributos
    private double precioMaximo;

    // Constructores
    public CondicionPrecioEnvio(double precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoDeCarga paquete) {
        return paquete.getCostoEnvio() < this.precioMaximo;
    }
}
