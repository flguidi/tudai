package tp10.e04.condiciones;

import tp10.e04.Gasto;

public class CondicionDescripcion<T> extends Condicion<T> {
    // Atributos
    private String descripcion;

    // Constructores
    public CondicionDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Gasto<T> gasto) {
        return gasto.getDescripcion().equalsIgnoreCase(this.descripcion);
    }
}
