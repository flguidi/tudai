package tp09.e03.comparadores;

import tp09.e03.Candidato;
import java.util.Comparator;

public class ComparadorAgrupacion implements Comparator<Candidato> {
    @Override
    public int compare(Candidato c1, Candidato c2) {
        return c1.getAgrupacion().compareTo(c2.getAgrupacion());
    }
}
