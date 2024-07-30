package tp10.e04;

import tp10.e04.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;

public class GastoDetallado<T> implements Gasto<T> {
    // Atributos
    private String descripcion;
    private LocalDate fecha;
    private ArrayList<Caracteristica<T>> caracteristicas;
    private ArrayList<Gasto<T>> gastos; // Detalles

    // Constructores
    public GastoDetallado(String descripcion, LocalDate fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.caracteristicas = new ArrayList<>();
        this.gastos = new ArrayList<>();
    }

    // Métodos
    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public LocalDate getFecha() {
        return this.fecha;
    }

    public void agregarGasto(Gasto<T> gasto) {
        this.gastos.add(gasto);
    }

    public void eliminarGasto(Gasto<T> gasto) {
        this.gastos.remove(gasto);
    }

    @Override
    public double getMonto() {
        double total = 0;
        for (Gasto<T> g : this.gastos)
            total += g.getMonto();
        return total;
    }

    @Override
    public double calcularMontoEspecifico(Condicion<T> condicion) {
        double total = 0;
        for (Gasto<T> g : this.gastos)
            total += g.calcularMontoEspecifico(condicion);
        return total;
    }

    @Override
    public void agregarCaracteristica(String nombre, T valor) {
        this.caracteristicas.add(new Caracteristica<>(nombre, valor));
    }

    @Override
    public void eliminarCaracteristica() {
        this.caracteristicas.removeLast();
    }

    @Override
    public boolean tieneCaracteristica(String nombre, T valor) {
        for (Caracteristica<T> c : this.caracteristicas) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getValor().equals(valor))
                return true;
        }
        return false;
    }

    @Override
    public ArrayList<Gasto<T>> buscar(Condicion<T> condicion) {
        ArrayList<Gasto<T>> busqueda = new ArrayList<>();
        if (condicion.esCumplidaPor(this))
            busqueda.add(this);
        for (Gasto<T> g : this.gastos)
            busqueda.addAll(g.buscar(condicion));
        return busqueda;
    }

    @Override
    public String listar(int nivelIndentacion) {
        // Indentación
        String indentacion = "";
        for (int i = 0; i < nivelIndentacion; i++)
            indentacion += "\t";

        // Combo
        String lista = indentacion + this + "\n";

        // Elementos
        for (Gasto<T> g : this.gastos)
            lista += g.listar(nivelIndentacion + 1) + "\n";

        return lista;
    }

    @Override
    public String toString() {
        return this.getDescripcion() + ": $" + this.getMonto();
    }
}
