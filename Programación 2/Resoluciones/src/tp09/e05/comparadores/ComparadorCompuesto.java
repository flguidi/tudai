package tp09.e05.comparadores;

import tp09.e05.Seguro;
import java.util.Comparator;

public class ComparadorCompuesto implements Comparator<Seguro> {
    // Atributos
    private Comparator<Seguro> criterio1;
    private Comparator<Seguro> criterio2;

    // Constructores
    public ComparadorCompuesto(Comparator<Seguro> criterio1, Comparator<Seguro> criterio2) {
        this.criterio1 = criterio1;
        this.criterio2 = criterio2;
    }

    // Métodos
    @Override
    public int compare(Seguro s1, Seguro s2) {
        int resultado = criterio1.compare(s1, s2);
        if (resultado != 0)
            return resultado;
        else
            return criterio2.compare(s1, s2);
    }
}
