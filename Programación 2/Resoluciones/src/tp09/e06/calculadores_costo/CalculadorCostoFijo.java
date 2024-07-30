package tp09.e06.calculadores_costo;

public class CalculadorCostoFijo extends CalculadorCosto {
    // Atributos
    private double costo;

    // Constructores
    public CalculadorCostoFijo(double costo) {
        this.costo = costo;
    }

    // Métodos
    @Override
    public double calcular() {
        return this.costo;
    }
}
