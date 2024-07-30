package recuperatorio_2022_11_10;

import recuperatorio_2022_11_10.condiciones.Condicion;
import java.util.ArrayList;

public class Seccion extends ElementoPortal {
    // Atributos
    protected ArrayList<ElementoPortal> elementos;

    // Constructores
    public Seccion(String categoria) {
        super(categoria);
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public void agregarElemento(ElementoPortal elemento) {
        if (!elementos.contains(elemento)) {
            // Inserción ordenada
            int i = 0;
            while (i < elementos.size() && elemento.compareTo(elementos.get(i)) > 0)
                i++;

            if (i < elementos.size())
                elementos.add(i, elemento);
            else
                elementos.add(elemento);
        }
    }

    public boolean tieneElementos() {
        return !elementos.isEmpty();
    }

    @Override
    public ArrayList<String> obtenerPalabrasClaves() {
        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < elementos.size(); i++) {
            ElementoPortal hijo = elementos.get(i);
            ArrayList<String> palabrasHijo = hijo.obtenerPalabrasClaves();
            for (int j = 0; j < palabrasHijo.size(); j++) {
                if (!resultado.contains(palabrasHijo.get(j)))
                    resultado.add(palabrasHijo.get(j));
            }
        }
        return resultado;
    }

    @Override
    public ElementoPortal copiar(Condicion condicion) {
        Seccion copia = new Seccion(this.getCategoria());
        for (int i = 0; i < elementos.size(); i++) {
            ElementoPortal copiaHijo = elementos.get(i).copiar(condicion);
            if (copiaHijo != null)
                copia.agregarElemento(copiaHijo);
        }
        if (copia.tieneElementos())
            return copia;
        else
            return null;
    }

    @Override
    public String toString() {
        String str = this.getCategoria() + " / ";
        for (int i = 0; i < elementos.size(); i++)
            str += elementos.get(i).toString() + " ";
        str += "\n";
        return str;
    }
}
