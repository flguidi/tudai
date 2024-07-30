package tp08.e03;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Toma un nodo dado y lo agrega a una lista ordenada ascendentemente.
 */
public class AgregarAListaAscendente implements AccionEjecutable {
    // Atributos
    private ArrayList<Nodo> lista;

    // Constructores
    public AgregarAListaAscendente() {
        this.lista = new ArrayList<>();
    }

    // Métodos
    @Override
    public void ejecutarNodo(Object nodo) {
        lista.add((Nodo) nodo);
        Collections.sort(lista);
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
