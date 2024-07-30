package tp10.e02;

import tp10.e02.criterios_prediccion.CriterioPrediccion;
import java.util.ArrayList;

public class Sensor {
    // Atributos
    private String tipo;
    private ArrayList<Integer> registros;
    private CriterioPrediccion criterioPrediccion;

    // Constructores
    public Sensor(String tipo, CriterioPrediccion criterioPrediccion) {
        this.tipo = tipo;
        this.registros = new ArrayList<>();
        this.criterioPrediccion = criterioPrediccion;
    }

    // Métodos
    public String getTipo() {
        return tipo;
    }

    public void setCriterioPrediccion(CriterioPrediccion criterioPrediccion) {
        this.criterioPrediccion = criterioPrediccion;
    }

    public void registrarDato(int dato) {
        this.registros.add(dato);
    }

    public int ultimoRegistro() {
        return this.registros.getLast();
    }

    public ArrayList<Integer> ultimosRegistros(int cantidad) {
        ArrayList<Integer> ultimosRegistros = new ArrayList<>();

        int cantidadTotal = this.registros.size();

        if (cantidad > cantidadTotal)
            cantidad = cantidadTotal;

        for (int i = cantidadTotal - cantidad; i < cantidadTotal; i++)
            ultimosRegistros.add(this.registros.get(i));

        return ultimosRegistros;
    }

    public void eliminarUltimoRegistro() {
        this.registros.removeLast();
    }

    public boolean predecirLluvia() {
        return this.criterioPrediccion.predecir(this);
    }
}
