package tp09.e02.condiciones;

import tp09.e02.ElementoSA;

public class CondicionNombreParcial extends Condicion {
    // Atributos
    private String nombre;

    // Constructores
    public CondicionNombreParcial(String nombre) {
        this.nombre = nombre;
    }

    // Métodos
    public boolean esCumplidaPor(ElementoSA elemento) {
        return elemento.getNombre().contains(nombre);
    }
}
