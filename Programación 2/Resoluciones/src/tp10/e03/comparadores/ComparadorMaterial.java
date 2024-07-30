package tp10.e03.comparadores;

import tp10.e03.Pedido;
import java.util.Comparator;

public class ComparadorMaterial implements Comparator<Pedido> {
    @Override
    public int compare(Pedido p1, Pedido p2) {
        return p1.getMaterial().compareTo(p2.getMaterial());
    }
}
