package recuperatorio_2022_11_10;

import recuperatorio_2022_11_10.condiciones.Condicion;
import java.util.ArrayList;

public abstract class ElementoPortal implements Comparable<ElementoPortal> {
    // Atributos
    private String categoria;

    // Constructores
    public ElementoPortal(String categoria) {
        this.categoria = categoria;
    }

    // Métodos
    public String getCategoria() {
        return categoria;
    }

    public abstract ArrayList<String> obtenerPalabrasClaves();

    public abstract ElementoPortal copiar(Condicion condicion);

    public int compareTo(ElementoPortal otro) {
        return this.categoria.compareTo(otro.getCategoria());
    }
}
