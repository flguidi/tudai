package tp09.e03.comparadores;

import tp09.e03.Candidato;
import java.util.Comparator;

public class ComparadorCompuesto implements Comparator<Candidato> {
    // Atributos
    private Comparator<Candidato> criterio1;
    private Comparator<Candidato> criterio2;

    // Constructores
    public ComparadorCompuesto(Comparator<Candidato> criterio1, Comparator<Candidato> criterio2) {
        this.criterio1 = criterio1;
        this.criterio2 = criterio2;
    }

    // Métodos
    @Override
    public int compare(Candidato c1, Candidato c2) {
        int resultado = criterio1.compare(c1, c2);
        if (resultado != 0)
            return resultado;
        else
            return criterio2.compare(c1, c2);
    }
}
