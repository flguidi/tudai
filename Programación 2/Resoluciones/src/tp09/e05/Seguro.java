package tp09.e05;

import tp09.e05.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Seguro {
    // Atributos
    private int dniDuenio;

    // Constructores
    public Seguro(int dniDuenio) {
        this.dniDuenio = dniDuenio;
    }

    // Métodos
    public int getDniDuenio() {
        return this.dniDuenio;
    }

    public abstract int getNumeroPoliza();

    public abstract double getMontoAsegurado();

    public abstract double calcularCosto();

    public abstract ArrayList<SeguroSimple> buscar(Condicion cond, Comparator<Seguro> comp);
}
