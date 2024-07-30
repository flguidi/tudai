package tp09.e02.condiciones;

import tp09.e02.ElementoSA;

public class CondicionNombreIgual extends Condicion {
    // Atributos
    private String nombre;

    // Constructores
    public CondicionNombreIgual(String nombre) {
        this.nombre = nombre;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSA elemento) {
        return elemento.getNombre().equals(nombre);
    }
}
