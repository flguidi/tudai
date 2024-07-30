package recuperatorio_2021_11_11;

import java.util.ArrayList;

public class Producto extends ElementoBazar {
    // Atributos
    private ArrayList<String> categorias;
    private double peso;
    private double precio;

    // Constructores
    public Producto(double peso, double precio) {
        this.peso = peso;
        this.precio = precio;
    }

    // Métodos
    @Override
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int getCantidad() {
        return 1;
    }

    @Override
    public ArrayList<String> getCategorias() {
        return new ArrayList<>(categorias);
    }

    public void agregarCategoria(String categoria) {
        if (!categorias.contains(categoria))
            categorias.add(categoria);
    }

    public void eliminarCategoria(String categoria) {
        categorias.remove(categoria);
    }

    @Override
    public boolean tieneCategoria(String categoria) {
        return categorias.contains(categoria);
    }
}
