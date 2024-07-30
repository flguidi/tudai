package tp04.e03;

public class EmpleadoHorasExtras extends EmpleadoContratado {
    // Atributos
    private double montoHoraExtra;
    private int horasExtras;

    // Constructores
    public EmpleadoHorasExtras(String nombre, int id, double sueldoFijo, double montoHoraExtra) {
        super(nombre, id, sueldoFijo);
        this.montoHoraExtra = montoHoraExtra;
        this.horasExtras = 0;
    }

    // Métodos
    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getMontoHoraExtra() {
        return montoHoraExtra;
    }

    public void setMontoHoraExtra(double montoHoraExtra) {
        this.montoHoraExtra = montoHoraExtra;
    }

    @Override
    public double getSueldoSemanal() {
        return super.getSueldoSemanal() + this.horasExtras * this.montoHoraExtra;
    }

    @Override
    public String toString() {
        return super.toString() + " - " +
                "Horas extras: " + this.horasExtras + " - " +
                "Monto por hora extra: " + this.montoHoraExtra;
    }
}
