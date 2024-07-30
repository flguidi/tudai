package tp10.e06;

import tp10.e06.comparadores.*;
import tp10.e06.condiciones.*;
import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        // Huéspedes
        Huesped huesped1 = new Huesped("Juan", "Pérez", 45, "Las Leñas");
        Huesped huesped2 = new Huesped("Martina", "Álvarez", 56, "Las Leñas");

        // Habitaciones
        Habitacion h1 = new Habitacion("H-001", 15, 2, LocalDate.of(2024, 5, 16), true);
        h1.agregarCaracteristica("Aire acondicionado");
        h1.agregarHuesped(huesped1);
        h1.agregarHuesped(huesped2);

        Habitacion h2 = new Habitacion("H-002", 25, 4, LocalDate.of(2024, 5, 22), true);
        h2.agregarCaracteristica("Aire acondicionado");

        Habitacion h3 = new Habitacion("H-003", 25, 3, LocalDate.of(2024, 6, 4), false);
        h3.agregarCaracteristica("Vista al mar");

        // Pabellón
        GrupoDeAlojamientos pabellon = new GrupoDeAlojamientos();
        pabellon.agregarUnidad(h1);
        pabellon.agregarUnidad(h2);

        // Hotel
        GrupoDeAlojamientos hotel = new GrupoDeAlojamientos();
        hotel.agregarUnidad(pabellon);
        hotel.agregarUnidad(h3);

        // PRUEBA DE SERVICIOS
        // Búsquedas
        Condicion condDisponibilidad = new CondicionDisponibilidad();
        Condicion condCaracteristica = new CondicionCaracteristica("Aire acondicionado");
        Condicion condCompuesta = new CondicionAnd(condDisponibilidad, condCaracteristica);
        Comparator<Habitacion> compSuperficie = new ComparadorSuperficie();

        System.out.print("Habitaciones disponibles con aire acondicionado: ");
        System.out.println(hotel.buscar(condCompuesta, compSuperficie));

        int superficie = 24;
        Condicion condSuperficie = new CondicionSuperficie(superficie);
        condCompuesta = new CondicionAnd(condDisponibilidad, condSuperficie);
        Comparator<Habitacion> compCamas = new ComparadorCamas();

        System.out.print("Habitaciones con más de " + superficie + " m2: ");
        System.out.println(hotel.buscar(condCompuesta, compCamas));

        // Dimensión total
        System.out.println("Dimensión total del hotel: " + hotel.getSuperficie());
    }
}
