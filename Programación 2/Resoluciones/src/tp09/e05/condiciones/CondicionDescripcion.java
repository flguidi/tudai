package tp09.e05.condiciones;

import tp09.e05.SeguroSimple;

public class CondicionDescripcion extends Condicion {
    // Atributos
    private String descripcion;

    // Constructores
    public CondicionDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(SeguroSimple seguro) {
        return seguro.getDescripcion().contains(descripcion);
    }
}
