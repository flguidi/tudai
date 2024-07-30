package tp10.e03.comparadores;

import tp10.e03.Pedido;
import java.util.Comparator;

public class ComparadorGanancia implements Comparator<Pedido> {
    @Override
    public int compare(Pedido p1, Pedido p2) {
        return Double.compare(p1.calcularGanancia(), p2.calcularGanancia());
    }
}
