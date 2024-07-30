package tp09.e02.comparadores;

import tp09.e02.ElementoSA;
import java.util.Comparator;

public class ComparadorTamanio implements Comparator<ElementoSA> {
    @Override
    public int compare(ElementoSA e1, ElementoSA e2) {
        return Double.compare(e1.getTamanio(), e2.getTamanio());
    }
}
