package tp09.e07;

import tp09.e07.condiciones.Condicion;
import java.util.ArrayList;

public class Producto extends ElementoBazar {
    // Atributos
    private double precio;
    private double peso;

    // Constructores
    public Producto(String nombre, double precio, double peso) {
        super(nombre);
        this.precio = precio;
        this.peso = peso;
    }

    // Métodos
    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public int cantidadProductos() {
        return 1;
    }

    @Override
    public ArrayList<ElementoBazar> buscar(Condicion condicion) {
        ArrayList<ElementoBazar> busqueda = new ArrayList<>();
        if (condicion.esCumplidaPor(this))
            busqueda.add(this);
        return busqueda;
    }

    @Override
    public String listar(int nivelIndentacion) {
        String indentacion = "";
        for (int i = 0; i < nivelIndentacion; i++)
            indentacion += "\t";
        return indentacion + this.getNombre();
    }
}
