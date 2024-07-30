package tp09.e02;

import tp09.e02.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class Archivo extends ElementoSA {
    // Atributos
    private double tamanio;

    // Constructores
    public Archivo(String nombre, double tamanio) {
        super(nombre);
        this.tamanio = tamanio;
    }

    // Métodos
    @Override
    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public ArrayList<ElementoSA> buscar(Condicion condicion, Comparator<ElementoSA> comparador) {
        ArrayList<ElementoSA> resultado = new ArrayList<>();
        if (condicion.esCumplidaPor(this))
            resultado.add(this);
        return resultado;
    }
}
