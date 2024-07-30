package tp09.e06;

import tp09.e06.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class ElementoSimple extends ElementoAlquiler {
    // Atributos
    private String descripcion;
    private double valor;
    private int antiguedad; // Meses de antigüedad del elemento

    // Constructores
    public ElementoSimple(String id, String descripcion, double valor, int antiguedad) {
        super(id);
        this.descripcion = descripcion;
        this.valor = valor;
        this.antiguedad = antiguedad;
    }

    // Métodos
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int getAntiguedad() {
        return this.antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public double calcularCosto() {
        if (this.calculadorCosto == null)
            return 0.0;

        return this.calculadorCosto.calcular();
    }

    @Override
    public ArrayList<ElementoSimple> buscar(Condicion cond, Comparator<ElementoAlquiler> comp) {
        ArrayList<ElementoSimple> busqueda = new ArrayList<>();
        if (cond.esCumplidaPor(this))
            busqueda.add(this);
        return busqueda;
    }
}
