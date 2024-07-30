package tp10.e06.comparadores;

import tp10.e06.Habitacion;
import java.util.Comparator;

public class ComparadorSuperficie implements Comparator<Habitacion> {
    @Override
    public int compare(Habitacion h1, Habitacion h2) {
        return Integer.compare(h1.getSuperficie(), h2.getSuperficie());
    }
}
