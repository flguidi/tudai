package tp09.e02;

import tp09.e02.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Carpeta extends ElementoSA {
    // Atributos
    protected ArrayList<ElementoSA> elementos;

    // Constructores
    public Carpeta(String nombre) {
        super(nombre);
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public void agregarElemento(ElementoSA elemento) {
        if (!elementos.contains(elemento)) {
            // Se elimina el elemento del contenedor anterior
            if (elemento.getContenedor() != null) {
                Carpeta contenedorAnterior = (Carpeta) elemento.getContenedor();
                contenedorAnterior.eliminarElemento(elemento);
            }

            // Se asigna este directorio como nuevo contenedor y se agrega el elemento
            elemento.setContenedor(this);
            elementos.add(elemento);
        }
    }

    public void eliminarElemento(ElementoSA elemento) {
        elementos.remove(elemento);
    }

    @Override
    public ArrayList<ElementoSA> buscar(Condicion condicion, Comparator<ElementoSA> comparador) {
        ArrayList<ElementoSA> resultado = new ArrayList<>();

        if (condicion.esCumplidaPor(this))
            resultado.add(this);

        for (int i = 0; i < elementos.size(); i++) {
            ElementoSA elemento = elementos.get(i);
            resultado.addAll(elemento.buscar(condicion, null));
        }

        if (comparador == null)
            Collections.sort(resultado);
        else
            resultado.sort(comparador);

        return resultado;
    }

    @Override
    public int getCantidadElementos() {
        int total = super.getCantidadElementos(); // Se cuenta el directorio a sí mismo
        for (int i = 0; i < elementos.size(); i++)
            total += elementos.get(i).getCantidadElementos();
        return total;
    }

    @Override
    public double getTamanio() {
        double total = 0;
        for (int i = 0; i < elementos.size(); i++)
            total += elementos.get(i).getTamanio();
        return total;
    }
}
