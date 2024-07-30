package tp09.e06.comparadores;

import tp09.e06.ElementoAlquiler;
import java.util.Comparator;

public class ComparadorAntiguedad implements Comparator<ElementoAlquiler> {
    @Override
    public int compare(ElementoAlquiler e1, ElementoAlquiler e2) {
        return Integer.compare(e1.getAntiguedad(), e2.getAntiguedad());
    }
}
