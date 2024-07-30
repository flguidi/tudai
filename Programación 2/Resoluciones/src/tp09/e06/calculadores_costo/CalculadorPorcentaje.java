package tp09.e06.calculadores_costo;

public class CalculadorPorcentaje extends CalculadorCosto {
    // Atributos
    private double valor;
    private double porcentaje;

    // Constructores
    public CalculadorPorcentaje(double valor, double porcentaje) {
        this.valor = valor;
        this.porcentaje = porcentaje;
    }

    // Métodos
    @Override
    public double calcular() {
        return valor * porcentaje;
    }
}
