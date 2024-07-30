package tp09.e01.comparadores;

import tp09.e01.Socio;
import java.util.Comparator;

public class ComparadorCompuesto implements Comparator<Socio> {
    // Atributos
    private Comparator<Socio> comparador1;
    private Comparator<Socio> comparador2;

    // Constructores
    public ComparadorCompuesto(Comparator<Socio> comparador1, Comparator<Socio> comparador2) {
        this.comparador1 = comparador1;
        this.comparador2 = comparador2;
    }

    // Métodos
    @Override
    public int compare(Socio s1, Socio s2) {
        int resultado = comparador1.compare(s1, s2);
        if (resultado != 0)
            return resultado;
        return comparador2.compare(s1, s2);
    }
}
