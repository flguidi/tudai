package tp09.e06;

import tp09.e06.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class Combo extends ElementoAlquiler {
    // Atributos
    private ArrayList<ElementoAlquiler> elementos;

    // Constructores
    public Combo(String id) {
        super(id);
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public void agregarElemento(ElementoAlquiler elemento) {
        this.elementos.add(elemento);
    }

    public void eliminarElemento(ElementoAlquiler elemento) {
        this.elementos.remove(elemento);
    }

    @Override
    public double getValor() {
        double valor = 0;
        for (ElementoAlquiler e : this.elementos)
            valor += e.getValor();
        return valor;
    }

    @Override
    public int getAntiguedad() {
        int antiguedad = 0;
        for (ElementoAlquiler e : this.elementos) {
            if (e.getAntiguedad() > antiguedad)
                antiguedad = e.getAntiguedad();
        }
        return antiguedad;
    }

    @Override
    public double calcularCosto() {
        double total = 0;
        for (ElementoAlquiler e : this.elementos)
            total += e.calcularCosto();
        return total;
    }

    @Override
    public ArrayList<ElementoSimple> buscar(Condicion cond, Comparator<ElementoAlquiler> comp) {
        ArrayList<ElementoSimple> busqueda = new ArrayList<>();
        for (ElementoAlquiler e : this.elementos)
            busqueda.addAll(e.buscar(cond, comp));

        busqueda.sort(comp); // Se ordena la lista antes de devolverse
        return busqueda;
    }
}
