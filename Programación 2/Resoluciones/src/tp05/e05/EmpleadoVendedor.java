package tp05.e05;

public class EmpleadoVendedor extends Empleado {
    // Atributos
    private double montoVentas;
    private double porcentajeExtra;

    // Constructores
    public EmpleadoVendedor(String nombre, String apellido, String dni, double sueldoMensual,
                            double porcentajeExtra) {
        super(nombre, apellido, dni, sueldoMensual);
        this.porcentajeExtra = porcentajeExtra;
        this.montoVentas = 0;
    }

    // Métodos
    public double getMontoVentas() {
        return montoVentas;
    }

    public void agregarMontoVentas(double importe) {
        this.montoVentas += importe;
    }

    public void reiniciarMontoVentas() {
        this.montoVentas = 0;
    }

    public double getPorcentajeExtra() {
        return porcentajeExtra;
    }

    @Override
    public double getSueldoTotal() {
        return this.getSueldoMensual() + this.montoVentas * this.porcentajeExtra;
    }

}
