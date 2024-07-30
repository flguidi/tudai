package tp09.e06;

import tp09.e06.calculadores_costo.CalculadorCosto;
import tp09.e06.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class ElementoAlquiler {
    // Atributos
    private String id;
    protected CalculadorCosto calculadorCosto;

    // Constructores
    public ElementoAlquiler(String id) {
        this.id = id;
        this.calculadorCosto = null;
    }

    // Métodos
    public String getId() {
        return id;
    }

    public abstract double getValor();

    public abstract int getAntiguedad();

    public void setCalculadorCosto(CalculadorCosto calculadorCosto) {
        this.calculadorCosto = calculadorCosto;
    }

    public abstract double calcularCosto();

    public abstract ArrayList<ElementoSimple> buscar(Condicion cond, Comparator<ElementoAlquiler> comp);

    @Override
    public String toString() {
        return this.id;
    }
}
