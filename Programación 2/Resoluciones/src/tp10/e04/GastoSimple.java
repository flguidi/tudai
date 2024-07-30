package tp10.e04;

import tp10.e04.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;

public class GastoSimple<T> implements Gasto<T> {
    // Atributos
    private String descripcion;
    private LocalDate fecha;
    private double monto;
    private ArrayList<Caracteristica<T>> caracteristicas;

    // Constructores
    public GastoSimple(String descripcion, LocalDate fecha, double monto) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.monto = monto;
        this.caracteristicas = new ArrayList<>();
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

    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public double calcularMontoEspecifico(Condicion<T> condicion) {
        if (condicion.esCumplidaPor(this))
            return this.getMonto();
        else
            return 0.0;
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
        return busqueda;
    }

    @Override
    public String listar(int nivelIndentacion) {
        String indentacion = "";
        for (int i = 0; i < nivelIndentacion; i++)
            indentacion += "\t";
        return indentacion + this;
    }

    @Override
    public String toString() {
        return this.getDescripcion() + ": $" + this.getMonto();
    }
}
