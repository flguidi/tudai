package tp09.e07;

import tp09.e07.condiciones.Condicion;
import java.util.ArrayList;

public abstract class ElementoBazar {
    // Atributos
    private String nombre;
    private ArrayList<String> categorias;

    // Constructores
    public ElementoBazar(String nombre) {
        this.nombre = nombre;
        this.categorias = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCategoria(String categoria) {
        if (!this.categorias.contains(categoria))
            this.categorias.add(categoria);
    }

    public void eliminarCategoria(String categoria) {
        this.categorias.remove(categoria);
    }

    public boolean tieneCategoria(String categoria) {
        return this.categorias.contains(categoria);
    }

    public ArrayList<String> getCategorias() {
        return new ArrayList<>(this.categorias);
    }

    public abstract double getPrecio();

    public abstract double getPeso();

    public abstract int cantidadProductos();

    public abstract ArrayList<ElementoBazar> buscar(Condicion condicion);

    public abstract String listar(int nivelIndentacion);

    @Override
    public String toString() {
        return this.nombre;
    }
}
