package recuperatorio_2022_11_10;

import recuperatorio_2022_11_10.condiciones.Condicion;
import java.util.ArrayList;

public class SeccionRestringida extends Seccion {
    // Atributos
    private ArrayList<String> categoriasAdmisibles;

    // Constructores
    public SeccionRestringida(String categoria) {
        super(categoria);
    }

    // Métodos
    @Override
    public void agregarElemento(ElementoPortal elemento) {
        if (!elementos.contains(elemento) && categoriasAdmisibles.contains(elemento.getCategoria()))
            this.agregarElemento(elemento);
    }

    public void agregarCategoriaAdmisible(String categoria) {
        if (!categoriasAdmisibles.contains(categoria))
            categoriasAdmisibles.add(categoria);
    }

    @Override
    public ElementoPortal copiar(Condicion condicion) {
        SeccionRestringida copia = new SeccionRestringida(getCategoria());
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
}
