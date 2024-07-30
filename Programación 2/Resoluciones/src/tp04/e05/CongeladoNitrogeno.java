package tp04.e05;

import java.time.LocalDate;

public class CongeladoNitrogeno extends ProductoRC {
    // Atributos
    private String metodoCongelacion;
    private double segundosExposicion;

    // Constructores
    public CongeladoNitrogeno(String nombre, String tipo, LocalDate fechaEnvasado, LocalDate fechaVencimiento,
                              int numeroLote, String granjaOrigen, double temperatura, String codigo,
                              String metodoCongelacion, double segundosExposicion) {
        super(nombre, tipo, fechaEnvasado, fechaVencimiento, numeroLote, granjaOrigen, temperatura, codigo);
        this.metodoCongelacion = metodoCongelacion;
        this.segundosExposicion = segundosExposicion;
    }

    // Métodos
    public String getMetodoCongelacion() {
        return metodoCongelacion;
    }

    public void setMetodoCongelacion(String metodoCongelacion) {
        this.metodoCongelacion = metodoCongelacion;
    }

    public double getSegundosExposicion() {
        return segundosExposicion;
    }

    public void setSegundosExposicion(double segundosExposicion) {
        this.segundosExposicion = segundosExposicion;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Método de congelación: " + this.metodoCongelacion + " - " +
                "Tiempo de exposición al nitrógeno: " + this.segundosExposicion + " seg.";
    }
}
