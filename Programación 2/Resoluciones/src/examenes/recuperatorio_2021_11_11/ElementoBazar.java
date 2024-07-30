package recuperatorio_2021_11_11;

import java.util.ArrayList;

public abstract class ElementoBazar {
    public abstract double getPrecio();

    public abstract double getPeso();

    public abstract int getCantidad();

    public abstract ArrayList<String> getCategorias();

    public abstract boolean tieneCategoria(String categoria);
}
