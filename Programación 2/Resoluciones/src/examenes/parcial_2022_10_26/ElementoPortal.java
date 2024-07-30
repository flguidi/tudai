package parcial_2022_10_26;

import parcial_2022_10_26.condiciones.Condicion;
import java.util.ArrayList;

public abstract class ElementoPortal {
    public abstract String getCategoria();

    public abstract ArrayList<String> obtenerPalabrasClaves();

    public abstract ArrayList<Noticia> filtrar(Condicion condicion);
}
