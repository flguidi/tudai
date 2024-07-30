package tp10.e02.criterios_prediccion;

import tp10.e02.Sensor;

public class CriterioUltimoValor extends CriterioPrediccion {
    // Atributos
    private int valorMinimo;

    // Constructores
    public CriterioUltimoValor(int valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    // Métodos
    @Override
    public boolean predecir(Sensor sensor) {
        return sensor.ultimoRegistro() > valorMinimo;
    }
}
