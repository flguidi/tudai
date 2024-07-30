package tp09.e02;

import tp09.e02.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class Comprimido extends Carpeta {
    // Atributos
    private double tasaCompresion;

    // Constructores
    public Comprimido(String nombre, double tasaCompresion) {
        super(nombre);
        this.tasaCompresion = tasaCompresion;
    }

    // Métodos
    public double getTasaCompresion() {
        return tasaCompresion;
    }

    public void setTasaCompresion(double tasaCompresion) {
        this.tasaCompresion = tasaCompresion;
    }

    @Override
    public double getTamanio() {
        return super.getTamanio() * tasaCompresion;
    }

    @Override
    public ArrayList<ElementoSA> buscar(Condicion condicion, Comparator<ElementoSA> comparador) {
        ArrayList<ElementoSA> resultado = new ArrayList<>();
        for (int i = 0; i < elementos.size(); i++) {
            ElementoSA elemento = elementos.get(i);
            if (condicion.esCumplidaPor(elemento)) {
                resultado.add(this);
                break;
            }
        }

        return resultado;
    }
}
