package tp09.e04;

import tp09.e04.condiciones.Condicion;
import java.util.ArrayList;

public abstract class ElementoPortal {
    public abstract int contarNoticias();
    public abstract ElementoPortal copiar();
    public abstract ArrayList<Noticia> buscar(Condicion condicion);
    public abstract ArrayList<ElementoPortal> copiar(Condicion condicion);
    public abstract String imprimirLista();
}
