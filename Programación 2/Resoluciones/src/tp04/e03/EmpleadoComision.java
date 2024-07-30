package tp04.e03;

public class EmpleadoComision extends EmpleadoContratado {
    // Atributos
    private double porcentajeComision;
    private double montoVentasRealizadas;

    // Constructores
    public EmpleadoComision(String nombre, int id, double sueldoFijo, double porcentajeComision) {
        super(nombre, id, sueldoFijo);
        this.porcentajeComision = porcentajeComision;
        this.montoVentasRealizadas = 0;
    }

    // Métodos
    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public double getMontoVentasRealizadas() {
        return montoVentasRealizadas;
    }

    public void setMontoVentasRealizadas(double montoVentasRealizadas) {
        this.montoVentasRealizadas = montoVentasRealizadas;
    }

    public void registrarVenta(double monto) {
        this.montoVentasRealizadas += monto;
    }

    @Override
    public double getSueldoSemanal() {
        return super.getSueldoSemanal() + this.montoVentasRealizadas * this.porcentajeComision;
    }

    @Override
    public String toString() {
        return  super.toString() + " - " +
                "Porcentaje: " + this.porcentajeComision + " - " +
                "Monto de ventas realizadas: " + this.montoVentasRealizadas;
    }
}
