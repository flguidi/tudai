package tp10.e06;

import tp10.e06.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class UnidadHospedaje {
    public abstract int getSuperficie();
    public abstract ArrayList<String> getCaracteristicas();
    public abstract int cantidadHabitaciones(Condicion condicion);
    public abstract ArrayList<Habitacion> buscar(Condicion cond, Comparator<Habitacion> comp);
}
