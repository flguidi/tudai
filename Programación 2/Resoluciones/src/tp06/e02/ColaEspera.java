package tp06.e02;

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
            if (elemento.esMayor(elementos.get(i))) {
                elementos.add(i, elemento);
                encontro = true;
            }
            i++;
        }

        if (!encontro) elementos.add(elemento);
    }

    public boolean tieneElementos() {
        return !elementos.isEmpty();
    }

    public ElementoComparable obtenerSiguiente() {
        if (this.tieneElementos())
            return elementos.removeFirst();

        return null;
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}
