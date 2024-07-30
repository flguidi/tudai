package tp09.e07;

import tp09.e07.condiciones.Condicion;
import java.util.ArrayList;

public class Combo extends ElementoBazar {
    // Atributos
    private double descuento;
    private double topeDescuento;
    private Condicion condIncorporacion;
    protected ArrayList<ElementoBazar> elementos;

    // Constructores
    public Combo(String nombre, double descuento, double topeDescuento) {
        super(nombre);
        this.descuento = descuento;
        this.topeDescuento = topeDescuento;
        this.condIncorporacion = null;
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        if (descuento >= 0 && descuento <= 1)
            this.descuento = descuento;
    }

    public double getTopeDescuento() {
        return topeDescuento;
    }

    public void setTopeDescuento(double topeDescuento) {
        this.topeDescuento = topeDescuento;
    }

    public Condicion getCondIncorporacion() {
        return condIncorporacion;
    }

    public void setCondIncorporacion(Condicion condIncorporacion) {
        this.condIncorporacion = condIncorporacion;
    }

    public void agregarElemento(ElementoBazar elemento) {
        if (condIncorporacion == null || condIncorporacion.esCumplidaPor(elemento))
            this.elementos.add(elemento);
    }

    public void eliminarElemento(ElementoBazar elemento) {
        this.elementos.remove(elemento);
    }

    @Override
    public double getPrecio() {
        double total = 0;
        double totalDescuento = 0;
        for (ElementoBazar e : this.elementos) {
            if (totalDescuento > this.topeDescuento)
                this.descuento = this.topeDescuento;
            totalDescuento += this.descuento;
            total += e.getPrecio() * (1 - this.descuento);
        }
        return total;
    }

    @Override
    public double getPeso() {
        double total = 0;
        for (ElementoBazar e : this.elementos)
            total += e.getPeso();
        return total;
    }

    @Override
    public ArrayList<String> getCategorias() {
        ArrayList<String> lista = new ArrayList<>();
        for (ElementoBazar e : this.elementos) {
            ArrayList<String> categorias = e.getCategorias();
            for (String c : categorias) {
                if (!lista.contains(c))
                    lista.add(c);
            }
        }
        return lista;
    }

    @Override
    public boolean tieneCategoria(String categoria) {
        ArrayList<String> categorias = this.getCategorias();
        return categorias.contains(categoria);
    }

    @Override
    public int cantidadProductos() {
        int total = 0;
        for (ElementoBazar e : this.elementos)
            total += e.cantidadProductos();
        return total;
    }

    public ElementoBazar productoMenorPeso() {
        double pesoMenor = Integer.MAX_VALUE;
        ElementoBazar producto = null;
        for (ElementoBazar e : this.elementos) {
            double pesoActual = e.getPeso();
            if (e.getPeso() < pesoMenor) {
                pesoMenor = pesoActual;
                producto = e;
            }
        }
        return producto;
    }

    @Override
    public ArrayList<ElementoBazar> buscar(Condicion condicion) {
        ArrayList<ElementoBazar> busqueda = new ArrayList<>();
        if (condicion.esCumplidaPor(this)) {
            // Si este combo cumple la condición de búsqueda, se agrega a la lista
            busqueda.add(this);
        } else {
            // Sino, se propaga la búsqueda sobre sus elementos
            for (ElementoBazar e : this.elementos)
                busqueda.addAll(e.buscar(condicion));
        }
        return busqueda;
    }

    @Override
    public String listar(int nivelIndentacion) {
        // Indentación
        String indentacion = "";
        for (int i = 0; i < nivelIndentacion; i++)
            indentacion += "\t";

        // Combo
        String lista = indentacion + "Combo '" + this.getNombre() + "':\n";

        // Elementos
        for (ElementoBazar e : this.elementos)
            lista += e.listar(nivelIndentacion + 1) + "\n";

        return lista;
    }
}
