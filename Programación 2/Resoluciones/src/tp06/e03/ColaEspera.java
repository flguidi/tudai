package tp06.e03;

import java.util.ArrayList;

public class ColaEspera {
    // Atributos
    private ArrayList<ElementoComparable> elementos;

    // Constructores
    public ColaEspera() {
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public void agregarElemento(ElementoComparable elemento) {
        boolean encontro = false;
        int i = 0;

        while (i < elementos.size() && !encontro) {
            if (elemento.tieneMayorPrioridadQue(elementos.get(i))) {
                encontro = true;
                elementos.add(i, elemento);
            }
            i++;
        }

        if (!encontro)
            elementos.add(elemento);
    }

    public boolean tieneElementos() {
        return !elementos.isEmpty();
    }

    public ElementoComparable obtenerSiguiente() {
        if (tieneElementos())
            return elementos.removeFirst();

        return null;
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}
