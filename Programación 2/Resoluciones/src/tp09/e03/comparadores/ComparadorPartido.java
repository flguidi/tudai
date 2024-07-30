package tp09.e03.comparadores;

import tp09.e03.Candidato;
import java.util.Comparator;

public class ComparadorPartido implements Comparator<Candidato> {
    @Override
    public int compare(Candidato c1, Candidato c2) {
        return c1.getPartido().compareTo(c2.getPartido());
    }
}
