package tp10.e06.comparadores;

import tp10.e06.Habitacion;
import java.util.Comparator;

public class ComparadorCompuesto implements Comparator<Habitacion> {
    // Atributos
    Comparator<Habitacion> comparador1;
    Comparator<Habitacion> comparador2;

    // Constructores
    public ComparadorCompuesto(Comparator<Habitacion> comparador1, Comparator<Habitacion> comparador2) {
        this.comparador1 = comparador1;
        this.comparador2 = comparador2;
    }

    // Métodos
    @Override
    public int compare(Habitacion h1, Habitacion h2) {
        int comparacion = comparador1.compare(h1, h2);
        if (comparacion != 0)
            return comparacion;
        return comparador2.compare(h1, h2);
    }
}
