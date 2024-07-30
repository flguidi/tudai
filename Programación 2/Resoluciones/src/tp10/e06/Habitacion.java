package tp10.e06;

import tp10.e06.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Habitacion extends UnidadHospedaje {
    // Atributos
    private String id;
    private int superficie; // m2
    private int cantidadCamas;
    private LocalDate ultimaOcupacion;
    private boolean aceptaMascotas;
    private ArrayList<String> caracteristicas;
    private ArrayList<Huesped> huespedes;

    // Constructores
    public Habitacion(String id, int superficie, int cantidadCamas, LocalDate ultimaOcupacion, boolean aceptaMascotas) {
        this.id = id;
        this.superficie = superficie;
        this.cantidadCamas = cantidadCamas;
        this.ultimaOcupacion = ultimaOcupacion;
        this.aceptaMascotas = aceptaMascotas;
        this.caracteristicas = new ArrayList<>();
        this.huespedes = new ArrayList<>();
    }

    // Métodos
    public String getId() {
        return id;
    }

    @Override
    public int getSuperficie() {
        return superficie;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public LocalDate getUltimaOcupacion() {
        return ultimaOcupacion;
    }

    public boolean aceptaMascotas() {
        return aceptaMascotas;
    }

    @Override
    public ArrayList<String> getCaracteristicas() {
        return new ArrayList<>(caracteristicas);
    }

    public void agregarCaracteristica(String caracteristica) {
        if (!caracteristicas.contains(caracteristica))
            caracteristicas.add(caracteristica);
    }

    public void eliminarCaracteristica(String caracteristica) {
        caracteristicas.remove(caracteristica);
    }

    public boolean tieneCaracteristica(String caracteristica) {
        return this.caracteristicas.contains(caracteristica);
    }

    public void agregarHuesped(Huesped huesped) {
        if (!this.huespedes.contains(huesped) && this.cantidadCamas > this.huespedes.size())
            this.huespedes.add(huesped);
    }

    public void eliminarHuesped(Huesped huesped) {
        this.huespedes.remove(huesped);
    }

    public boolean estaDisponible() {
        return this.huespedes.isEmpty();
    }

    @Override
    public int cantidadHabitaciones(Condicion condicion) {
        if (condicion.esCumplidaPor(this))
            return 1;
        else
            return 0;
    }

    @Override
    public ArrayList<Habitacion> buscar(Condicion cond, Comparator<Habitacion> comp) {
        ArrayList<Habitacion> busqueda = new ArrayList<>();
        if (estaDisponible() && cond.esCumplidaPor(this))
            busqueda.add(this);
        return busqueda;
    }

    @Override
    public String toString() {
        return id;
    }
}
