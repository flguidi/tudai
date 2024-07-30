package tp10.e03.comparadores;

import tp10.e03.Pedido;
import java.util.Comparator;

public class ComparadorCompuesto implements Comparator<Pedido> {
    // Atributos
    Comparator<Pedido> comp1;
    Comparator<Pedido> comp2;

    // Constructores
    public ComparadorCompuesto(Comparator<Pedido> comp1, Comparator<Pedido> comp2) {
        this.comp1 = comp1;
        this.comp2 = comp2;
    }

    // Métodos
    @Override
    public int compare(Pedido p1, Pedido p2) {
        int comparacion = comp1.compare(p1, p2);
        if (comparacion != 0)
            return comparacion;
        return comp2.compare(p1, p2);
    }
}
