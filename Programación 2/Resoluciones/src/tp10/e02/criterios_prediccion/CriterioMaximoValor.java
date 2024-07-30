package tp10.e02.criterios_prediccion;

import tp10.e02.Sensor;
import java.util.ArrayList;

public class CriterioMaximoValor extends CriterioPrediccion {
    // Atributos
    private int valorMinimo;
    private int cantidadRegistros;

    // Constructores
    public CriterioMaximoValor(int valorMinimo, int cantidadRegistros) {
        this.valorMinimo = valorMinimo;
        this.cantidadRegistros = cantidadRegistros;
    }

    // Métodos
    @Override
    public boolean predecir(Sensor sensor) {
        ArrayList<Integer> ultimosRegistros = sensor.ultimosRegistros(cantidadRegistros);

        if (ultimosRegistros.isEmpty())
            return false;

        int valorMaximo = 0;
        for (Integer r : ultimosRegistros) {
            if (r > valorMaximo)
                valorMaximo = r;
        }
        return valorMaximo > this.valorMinimo;
    }
}
