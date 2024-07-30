package tp09.e01.comparadores;

import tp09.e01.Socio;
import java.util.Comparator;

public class ComparadorCancha implements Comparator<Socio> {
    // Atributos
    private int idCancha;

    // Constructores
    public ComparadorCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    // Métodos
    @Override
    public int compare(Socio s1, Socio s2) {
        return s1.cantAlquileresCancha(idCancha) - s2.cantAlquileresCancha(idCancha);
    }
}
