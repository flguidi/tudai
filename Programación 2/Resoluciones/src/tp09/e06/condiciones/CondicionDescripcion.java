package tp09.e06.condiciones;

import tp09.e06.ElementoSimple;

public class CondicionDescripcion extends Condicion {
    // Atributos
    private String descripcion;

    // Constructores
    public CondicionDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSimple elemento) {
        return elemento.getDescripcion().contains(descripcion);
    }
}
