package tp09.e06.calculadores_costo;

public class CalculadorCompuesto extends CalculadorCosto {
    // Atributos
    private CalculadorCosto calculador1;
    private CalculadorCosto calculador2;

    // Constructores
    public CalculadorCompuesto(CalculadorCosto calculador1, CalculadorCosto calculador2) {
        this.calculador1 = calculador1;
        this.calculador2 = calculador2;
    }

    // Métodos
    @Override
    public double calcular() {
        return calculador1.calcular() + calculador2.calcular();
    }
}
