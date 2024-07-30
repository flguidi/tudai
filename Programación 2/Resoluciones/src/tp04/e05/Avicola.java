package tp04.e05;

import java.util.ArrayList;

public class Avicola {
    // Atributos
    private String nombre;
    private ArrayList<Producto> productos;

    // Constructores
    public Avicola(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public Producto getProductoByIndice(int indice) {
        if (indice >= 0 && indice < productos.size())
            return productos.get(indice);

        return null;
    }

    public void agregarProducto(Producto producto) {
        if (!productos.contains(producto))
            this.productos.add(producto);
    }

    public void eliminarProducto(int indice) {
        if (indice >= 0 && indice < productos.size())
            this.productos.remove(indice);
    }

    public void imprimirListaProductos() {
        System.out.println(this.nombre.toUpperCase());
        System.out.println("***");
        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.println("***");
        }
    }
}
