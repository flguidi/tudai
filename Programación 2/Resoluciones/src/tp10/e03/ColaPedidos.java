package tp10.e03;

import java.util.ArrayList;
import java.util.Comparator;

public class ColaPedidos {
    // Atributos
    private ArrayList<Pedido> pedidos;

    // Constructores
    public ColaPedidos() {
        this.pedidos = new ArrayList<>();
    }

    // Métodos
    public void agregar(Pedido pedido, Comparator<Pedido> comparador) {
        this.pedidos.add(pedido);
        this.pedidos.sort(comparador);
    }

    public Pedido extraer() {
        return this.pedidos.removeFirst();
    }

    public void eliminar(Pedido pedido) {
        this.pedidos.remove(pedido);
    }

    public double calcularGananciaTotal() {
        double total = 0;
        for (Pedido p : this.pedidos)
            total += p.calcularGanancia();
        return total;
    }

    public void ordenar(Comparator<Pedido> comparator) {
        this.pedidos.sort(comparator);
    }

    public String listar() {
        String lista = "";
        for (Pedido p : this.pedidos)
            lista += p + "\n";
        return lista;
    }
}
