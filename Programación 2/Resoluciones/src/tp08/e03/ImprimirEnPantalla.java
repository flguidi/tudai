package tp08.e03;

/**
 * Imprime por pantalla el nodo pasado por parámetro.
 */
public class ImprimirEnPantalla implements AccionEjecutable {
    @Override
    public void ejecutarNodo(Object nodo) {
        System.out.print(nodo + " ");
    }
}
