package tp09.e02.comparadores;

import tp09.e02.ElementoSA;
import java.util.Comparator;

public class ComparadorNombre implements Comparator<ElementoSA> {
    @Override
    public int compare(ElementoSA e1, ElementoSA e2) {
        return e1.getNombre().compareTo(e2.getNombre());
    }
}
