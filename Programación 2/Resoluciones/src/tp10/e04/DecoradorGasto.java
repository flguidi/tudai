package tp10.e04;

import tp10.e04.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class DecoradorGasto<T> implements Gasto<T> {
    // Atributos
    protected Gasto<T> gastoDecorado;

    // Constructores
    public DecoradorGasto(Gasto<T> gastoDecorado) {
        this.gastoDecorado = gastoDecorado;
    }

    // Métodos
    @Override
    public String getDescripcion() {
        return gastoDecorado.getDescripcion();
    }

    @Override
    public LocalDate getFecha() {
        return gastoDecorado.getFecha();
    }

    @Override
    public double getMonto() {
        return gastoDecorado.getMonto();
    }

    @Override
    public double calcularMontoEspecifico(Condicion<T> condicion) {
        return gastoDecorado.calcularMontoEspecifico(condicion);
    }

    @Override
    public void agregarCaracteristica(String nombre, T valor) {
        gastoDecorado.agregarCaracteristica(nombre, valor);
    }

    @Override
    public void eliminarCaracteristica() {
        gastoDecorado.eliminarCaracteristica();
    }

    @Override
    public boolean tieneCaracteristica(String nombre, T valor) {
        return gastoDecorado.tieneCaracteristica(nombre, valor);
    }

    @Override
    public ArrayList<Gasto<T>> buscar(Condicion<T> condicion) {
        return gastoDecorado.buscar(condicion);
    }

    @Override
    public String listar(int nivelIndentacion) {
        return gastoDecorado.listar(nivelIndentacion);
    }
}
