package tp09.e05.comparadores;

import tp09.e05.Seguro;
import java.util.Comparator;

public class ComparadorNumPoliza implements Comparator<Seguro> {
    @Override
    public int compare(Seguro s1, Seguro s2) {
        return Integer.compare(s1.getNumeroPoliza(), s2.getNumeroPoliza());
    }
}
