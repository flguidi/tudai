package tp09.e01.comparadores;

import tp09.e01.Socio;
import java.util.Comparator;

public class ComparadorEdad implements Comparator<Socio> {
    @Override
    public int compare(Socio s1, Socio s2) {
        return s1.getEdad() - s2.getEdad();
    }
}
