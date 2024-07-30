package tp09.e05;

public class CalculadorPorcentaje extends CalculadorCosto {
    // Atributos
    private double porcentaje;
    private double montoAsegurado;

    // Constructores
    public CalculadorPorcentaje(double porcentaje, double montoAsegurado) {
        this.porcentaje = porcentaje;
        this.montoAsegurado = montoAsegurado;
    }

    // Métodos
    @Override
    public double calcular() {
        return this.montoAsegurado * this.porcentaje;
    }
}
