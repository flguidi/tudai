package tp04.e05;

import java.time.LocalDate;

/**
 * Productos refrigerados o congelados
 */
public class ProductoRC extends Producto {
    // Atributos
    private double temperaturaMantenimiento;
    private String codigoSupervision;

    // Constructores
    public ProductoRC(String nombre, String tipo, LocalDate fechaEnvasado, LocalDate fechaVencimiento,
                      int numeroLote, String granjaOrigen, double temperatura, String codigo) {
        super(nombre, tipo, fechaEnvasado, fechaVencimiento, numeroLote, granjaOrigen);
        this.temperaturaMantenimiento = temperatura;
        this.codigoSupervision = codigo;
    }

    // Métodos
    public double getTemperaturaMantenimiento() {
        return temperaturaMantenimiento;
    }

    public void setTemperaturaMantenimiento(double temperaturaMantenimiento) {
        this.temperaturaMantenimiento = temperaturaMantenimiento;
    }

    public String getCodigoSupervision() {
        return codigoSupervision;
    }

    public void setCodigoSupervision(String codigoSupervision) {
        this.codigoSupervision = codigoSupervision;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Temperatura de mantenimiento: " + this.temperaturaMantenimiento + " - " +
                "Código de supervisión: " + this.codigoSupervision;
    }
}
