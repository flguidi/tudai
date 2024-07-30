package tp08.e03;

/**
 * Cuenta cada nodo recorrido.
 */
public class ContarElemento implements AccionEjecutable {
    // Atributos
    private int contador;

    // Constructores
    public ContarElemento() {
        this.contador = 0;
    }

    // Métodos
    @Override
    public void ejecutarNodo(Object nodo) {
        contador++;
    }

    @Override
    public String toString() {
        return contador + "";
    }
}
