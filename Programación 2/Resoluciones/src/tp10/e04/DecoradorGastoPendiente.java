package tp10.e04;

public class DecoradorGastoPendiente<T> extends DecoradorGasto<T> {
    // Atributos
    private double porcentaje;
    private int cantidadDias;
    private boolean pendiente;

    // Constructores
    public DecoradorGastoPendiente(Gasto<T> gastoDecorado, double porcentaje, int cantidadDias, boolean pendiente) {
        super(gastoDecorado);
        this.porcentaje = porcentaje;
        this.cantidadDias = cantidadDias;
        this.pendiente = pendiente;
    }

    // Métodos
    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public boolean isPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    @Override
    public double getMonto() {
        double monto = super.getMonto();
        if (this.pendiente)
            monto += (monto * this.porcentaje * this.cantidadDias);
        return monto;
    }

    @Override
    public String toString() {
        return this.getDescripcion() + ": $" + this.getMonto();
    }
}
