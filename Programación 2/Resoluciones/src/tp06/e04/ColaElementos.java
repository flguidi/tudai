package tp06.e04;

import java.util.ArrayList;

public class ColaElementos {
    // Atributos
    private ArrayList<ElementoComparable> elementos; // Posee elementos comparables

    // Constructores
    public ColaElementos() {
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public void agregarElemento(ElementoComparable elemento) {
        // Se agrega el elemento dado según el criterio de ordenamiento establecido en comparar()
        boolean encontro = false;
        int i = 0;

        while (i < elementos.size() && !encontro) {
            if (elemento.comparar(elementos.get(i))) {
                encontro = true;
                elementos.add(i, elemento);
            }
            i++;
        }

        if (!encontro)
            elementos.add(elemento);
    }

    // Elimina el primer elemento de la cola y lo devuelve
    public ElementoComparable obtenerSiguiente() {
        if (tieneElementos())
            return elementos.removeFirst();

        return null;
    }

    // Verifica si la cola tiene elementos
    public boolean tieneElementos() {
        return !elementos.isEmpty();
    }

    @Override
    public String toString() {
        return elementos.toString();
    }

    // Más métodos...
}
