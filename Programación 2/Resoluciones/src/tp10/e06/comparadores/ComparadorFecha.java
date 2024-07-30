package tp10.e06.comparadores;

import tp10.e06.Habitacion;
import java.util.Comparator;

public class ComparadorFecha implements Comparator<Habitacion> {
    @Override
    public int compare(Habitacion h1, Habitacion h2) {
        return h1.getUltimaOcupacion().compareTo(h2.getUltimaOcupacion());
    }
}
