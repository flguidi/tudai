package tp03.e02;

import java.util.ArrayList;

public class FabricaMuebles {
    // Atributos
    private String nombre;
    private ArrayList<Mueble> stock;

    // Constructores
    public FabricaMuebles(String nombre) {
        this.nombre = nombre;
        this.stock = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mueble> getStock() {
        // Para respetar el encapsulamiento, se devuelve una copia del ArrayList 'stock'
        return new ArrayList<>(this.stock);
    }

    public Mueble getProducto(int indice) {
        if (indice >= 0 && indice < this.stock.size())
            return this.stock.get(indice);

        return null;
    }

    public void agregarProductoStock(Mueble mueble) {
        stock.add(mueble);
    }

    public void eliminarProductoStock(int indice) {
        if (indice >= 0 && indice < stock.size())
            stock.remove(indice);
    }

    public double getCostoFabricacion(int indice) {
        return stock.get(indice).getCostoFabricacion();
    }

    public double getValorVenta(int indice) {
        return stock.get(indice).calcularValorVenta(Main.MARGEN_BENEFICIO);
    }

    public String obtenerInformacionProductos(ArrayList<Mueble> inventario) {
        String lista = "";
        for (Mueble producto : inventario)
            lista += producto + "\n";
        return lista;
    }

    @Override
    public String toString() {
        return "|FABRICA DE MUEBLES| " +
                "Nombre: " + this.nombre + " - " +
                "Cantidad de productos en stock: " + this.stock.size() + "\n" +
                obtenerInformacionProductos(stock);
    }
}
