package tp05.e05;

public class EmpleadoBonos extends Empleado {
    // Atributos
    private double bono;
    private int minimoVentas;
    private int cantidadVentas;

    // Constructores
    public EmpleadoBonos(String nombre, String apellido, String dni, double sueldoMensual,
                         double bono, int minimoVentas) {
        super(nombre, apellido, dni, sueldoMensual);
        this.bono = bono;
        this.minimoVentas = minimoVentas;
        this.cantidadVentas = 0;
    }

    // Métodos
    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public int getMinimoVentas() {
        return minimoVentas;
    }

    public void setMinimoVentas(int minimoVentas) {
        this.minimoVentas = minimoVentas;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public void agregarVentas(int cantidadVentas) {
        this.cantidadVentas += cantidadVentas;
    }

    public void reiniciarVentas() {
        this.cantidadVentas = 0;
    }

    @Override
    public double getSueldoTotal() {
        double total = this.getSueldoMensual();
        if (this.cantidadVentas > this.minimoVentas)
            total += this.bono;
        return total;
    }
}
