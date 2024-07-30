package tp09.e05;

import tp09.e05.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class SeguroSimple extends Seguro {
    // Atributos
    private int numeroPoliza;
    private String descripcion;
    private double montoAsegurado;
    private CalculadorCosto calculadorCosto;

    // Constructores
    public SeguroSimple(int dniDuenio, int numeroPoliza, String descripcion, double montoAsegurado) {
        super(dniDuenio);
        this.numeroPoliza = numeroPoliza;
        this.descripcion = descripcion;
        this.montoAsegurado = montoAsegurado;
        this.calculadorCosto = null;
    }

    // Métodos
    @Override
    public int getNumeroPoliza() {
        return this.numeroPoliza;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public double getMontoAsegurado() {
        return this.montoAsegurado;
    }

    public void setCalculadorCosto(CalculadorCosto calculadorCosto) {
        this.calculadorCosto = calculadorCosto;
    }

    @Override
    public double calcularCosto() {
        if (this.calculadorCosto != null)
            return this.calculadorCosto.calcular();
        else
            return 0.0;
    }

    @Override
    public ArrayList<SeguroSimple> buscar(Condicion cond, Comparator<Seguro> comp) {
        ArrayList<SeguroSimple> busqueda = new ArrayList<>();
        if (cond.esCumplidaPor(this))
            busqueda.add(this);
        return busqueda;
    }

    @Override
    public String toString() {
        return "N." + this.numeroPoliza + " - '" + this.descripcion + "'";
    }
}
