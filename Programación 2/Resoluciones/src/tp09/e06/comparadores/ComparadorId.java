package tp09.e06.comparadores;

import tp09.e06.ElementoAlquiler;
import java.util.Comparator;

public class ComparadorId implements Comparator<ElementoAlquiler> {
    @Override
    public int compare(ElementoAlquiler e1, ElementoAlquiler e2) {
        return e1.getId().compareTo(e2.getId());
    }
}
