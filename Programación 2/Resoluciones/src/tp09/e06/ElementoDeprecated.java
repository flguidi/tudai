package tp09.e06;

import tp09.e06.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class ElementoDeprecated extends ElementoSimple {
    // Atributos
    private int mesesHastaCaducidad;
    private double porcentajeDescuento;

    // Constructores
    public ElementoDeprecated(String id, String descripcion, double valor, int antiguedad,
                              int mesesHastaCaducidad, double porcentajeDescuento) {
        super(id, descripcion, valor, antiguedad);
        this.mesesHastaCaducidad = mesesHastaCaducidad;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // Métodos
    public int getMesesHastaCaducidad() {
        return mesesHastaCaducidad;
    }

    public void setMesesHastaCaducidad(int meses) {
        this.mesesHastaCaducidad = meses;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double getValor() {
        double valorOriginal = super.getValor();

        if (this.getAntiguedad() <= this.mesesHastaCaducidad)
            return valorOriginal;
        else
            return valorOriginal - (valorOriginal * this.porcentajeDescuento); // Se aplica un descuento
    }

    @Override
    public double calcularCosto() {
        if (this.calculadorCosto == null)
            return 0.0;

        double costoOriginal = this.calculadorCosto.calcular();
        if (this.getAntiguedad() <= this.mesesHastaCaducidad)
            return costoOriginal;
        else
            return costoOriginal - (costoOriginal * this.porcentajeDescuento);
    }

    @Override
    public ArrayList<ElementoSimple> buscar(Condicion cond, Comparator<ElementoAlquiler> comp) {
        ArrayList<ElementoSimple> busqueda = new ArrayList<>();
        if (cond.esCumplidaPor(this) && this.getAntiguedad() <= this.mesesHastaCaducidad)
            busqueda.add(this);
        return busqueda;
    }
}
