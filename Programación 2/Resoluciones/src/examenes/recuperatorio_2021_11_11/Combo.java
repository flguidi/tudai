package recuperatorio_2021_11_11;

import recuperatorio_2021_11_11.condiciones.Condicion;
import java.util.ArrayList;

public class Combo extends ElementoBazar {
    // Atributos
    private double descuentoProducto;
    private double descuentoMaximo;
    private Condicion condIncorporacion;
    private ArrayList<ElementoBazar> elementos;

    // Constructores
    public Combo(double descuentoProducto, double descuentoMaximo) {
        this.descuentoProducto = descuentoProducto;
        this.descuentoMaximo = descuentoMaximo;
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public double getDescuentoMaximo() {
        return descuentoMaximo;
    }

    public void setDescuentoMaximo(double descuentoMaximo) {
        this.descuentoMaximo = descuentoMaximo;
    }

    public void agregarElemento(ElementoBazar elementoBazar) {
        if (condIncorporacion.esCumplidaPor(elementoBazar))
            elementos.add(elementoBazar);
    }

    @Override
    public int getCantidad() {
        int total = 0;
        for (ElementoBazar elemento : elementos)
            total += elemento.getCantidad();
        return total;
    }

    @Override
    public double getPrecio() {
        double total = 0;
        double descuento = 0;
        for (ElementoBazar elemento : elementos) {
            descuento = elemento.getCantidad() * descuentoProducto;
            if (descuento > descuentoMaximo)
                descuento = descuentoProducto;
            total += elemento.getPrecio() * descuento;
        }

        return total * descuento;
    }

    @Override
    public double getPeso() {
        double total = 0;
        for (ElementoBazar elemento : elementos)
            total += elemento.getPeso();
        return total;
    }

    public Producto obtenerProductoMenorPeso() {
        ElementoBazar menor = null;
        double peso = Double.MAX_VALUE;
        for (ElementoBazar elemento : elementos) {
            if (elemento.getPeso() < peso)
                menor = elemento;
        }
        return (Producto) menor;
    }

    @Override
    public ArrayList<String> getCategorias() {
        ArrayList<String> resultado = new ArrayList<>();
        for (ElementoBazar elemento : elementos) {
            ArrayList<String> categoriasHijo = elemento.getCategorias();
            for (String categoria : categoriasHijo) {
                if (!resultado.contains(categoria))
                    resultado.add(categoria);
            }
        }
        return resultado;
    }

    @Override
    public boolean tieneCategoria(String categoria) {
        ArrayList<String> categorias = new ArrayList<>(this.getCategorias());
        return categorias.contains(categoria);
    }
}
