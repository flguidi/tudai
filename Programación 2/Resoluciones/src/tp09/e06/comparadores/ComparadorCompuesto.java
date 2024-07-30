package tp09.e06.comparadores;

import tp09.e06.ElementoAlquiler;
import java.util.Comparator;

public class ComparadorCompuesto implements Comparator<ElementoAlquiler> {
    // Atributos
    private Comparator<ElementoAlquiler> criterio1;
    private Comparator<ElementoAlquiler> criterio2;

    // Constructores
    public ComparadorCompuesto(Comparator<ElementoAlquiler> criterio1, Comparator<ElementoAlquiler> criterio2) {
        this.criterio1 = criterio1;
        this.criterio2 = criterio2;
    }

    // Métodos
    @Override
    public int compare(ElementoAlquiler e1, ElementoAlquiler e2) {
        int resultado = criterio1.compare(e1, e2);
        if (resultado != 0)
            return resultado;
        else
            return criterio2.compare(e1, e2);
    }
}
