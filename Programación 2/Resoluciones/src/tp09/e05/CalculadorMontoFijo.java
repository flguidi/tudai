package tp09.e05;

public class CalculadorMontoFijo extends CalculadorCosto {
    // Atributos
    public double montoFijo;

    // Constructores
    public CalculadorMontoFijo(double montoFijo) {
        this.montoFijo = montoFijo;
    }

    // Métodos
    @Override
    public double calcular() {
        return this.montoFijo;
    }
}
