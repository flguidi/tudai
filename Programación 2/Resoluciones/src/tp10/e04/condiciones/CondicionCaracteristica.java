package tp10.e04.condiciones;

import tp10.e04.Caracteristica;
import tp10.e04.Gasto;

public class CondicionCaracteristica<T> extends Condicion<T> {
    // Atributos
    private String nombre;
    private T valor;

    // Constructores
    public CondicionCaracteristica(String nombre, T valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Gasto<T> gasto) {
        return gasto.tieneCaracteristica(this.nombre, this.valor);
    }
}
