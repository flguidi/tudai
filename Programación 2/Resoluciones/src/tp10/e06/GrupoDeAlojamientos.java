package tp10.e06;

import tp10.e06.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class GrupoDeAlojamientos extends UnidadHospedaje {
    // Atributos
    private ArrayList<UnidadHospedaje> unidades;

    // Constructores
    public GrupoDeAlojamientos() {
        this.unidades = new ArrayList<>();
    }

    // Métodos
    public void agregarUnidad(UnidadHospedaje unidad) {
        if (!unidades.contains(unidad))
            unidades.add(unidad);
    }

    public void eliminarUnidad(UnidadHospedaje unidad) {
        unidades.remove(unidad);
    }

    @Override
    public int getSuperficie() {
        int superficie = 0;
        for (UnidadHospedaje u : unidades)
            superficie += u.getSuperficie();
        return superficie;
    }

    @Override
    public ArrayList<String> getCaracteristicas() {
        ArrayList<String> lista = new ArrayList<>();
        for (UnidadHospedaje u : unidades) {
            ArrayList<String> listaParcial = u.getCaracteristicas();
            for (String caracteristica : listaParcial) {
                if (!lista.contains(caracteristica))
                    lista.add(caracteristica);
            }
        }
        return lista;
    }

    @Override
    public int cantidadHabitaciones(Condicion condicion) {
        int cantidad = 0;
        for (UnidadHospedaje u : unidades)
            cantidad += u.cantidadHabitaciones(condicion);
        return cantidad;
    }

    @Override
    public ArrayList<Habitacion> buscar(Condicion cond, Comparator<Habitacion> comp) {
        ArrayList<Habitacion> busqueda = new ArrayList<>();
        for (UnidadHospedaje u : this.unidades)
            busqueda.addAll(u.buscar(cond, comp));
        busqueda.sort(comp);
        return busqueda;
    }
}
