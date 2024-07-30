package parcial_2022_10_26;

import parcial_2022_10_26.condiciones.Condicion;
import java.util.ArrayList;

public class Seccion extends ElementoPortal {
    // Atributos
    private static final String CATEGORIA_POR_DEFECTO = "Sin definir";
    private int posicionCategoria;
    private ArrayList<ElementoPortal> elementosPortal;

    // Constructores
    public Seccion(int posicionCategoria) {
        this.posicionCategoria = posicionCategoria;
        this.elementosPortal = new ArrayList<>();
    }

    // Métodos
    public String getCategoria() {
        if (posicionCategoria < elementosPortal.size())
            return elementosPortal.get(posicionCategoria).getCategoria();
        else
            return CATEGORIA_POR_DEFECTO;
    }

    public int getPosicionCategoria() {
        return posicionCategoria;
    }

    public void setPosicionCategoria(int posicionCategoria) {
        this.posicionCategoria = posicionCategoria;
    }

    public void agregarElementoPortal(ElementoPortal elemento) {
        if (!elementosPortal.contains(elemento))
            elementosPortal.add(elemento);
    }

    public void eliminarElementoPortal(ElementoPortal elemento) {
        elementosPortal.remove(elemento);
    }

    @Override
    public ArrayList<String> obtenerPalabrasClaves() {
        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < elementosPortal.size(); i++) {
            ElementoPortal actual = elementosPortal.get(i);
            ArrayList<String> palabras = actual.obtenerPalabrasClaves();
            for (int j = 0; j < palabras.size(); j++) {
                if (!resultado.contains(palabras.get(j)))
                    resultado.add(palabras.get(j));
            }
        }
        return resultado;
    }

    @Override
    public ArrayList<Noticia> filtrar(Condicion condicion) {
        ArrayList<Noticia> resultado = new ArrayList<>();
        for (int i = 0; i < elementosPortal.size(); i++) {
            ElementoPortal actual = elementosPortal.get(i);
            resultado.addAll(actual.filtrar(condicion));
        }
        return resultado;
    }
}
