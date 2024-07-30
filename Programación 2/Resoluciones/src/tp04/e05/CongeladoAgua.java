package tp04.e05;

import java.time.LocalDate;

public class CongeladoAgua extends ProductoRC {
    // Atributos
    private double gramosSal;

    // Constructores
    public CongeladoAgua(String nombre, String tipo, LocalDate fechaEnvasado, LocalDate fechaVencimiento,
                         int numeroLote, String granjaOrigen, double temperatura, String codigo, double gramosSal) {
        super(nombre, tipo, fechaEnvasado, fechaVencimiento, numeroLote, granjaOrigen, temperatura, codigo);
        this.gramosSal = gramosSal;
    }

    // Métodos
    public double getGramosSal() {
        return gramosSal;
    }

    public void setGramosSal(double gramosSal) {
        this.gramosSal = gramosSal;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Salinidad de agua: " + this.gramosSal + "g/L";
    }
}
