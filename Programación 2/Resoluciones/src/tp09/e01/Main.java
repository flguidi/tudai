package tp09.e01;

import tp09.e01.comparadores.*;
import tp09.e01.condiciones.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        // Club
        Club club = new Club();

        // Socios
        Socio s1 = new Socio("Juan", "Pérez", 15, true);
        Socio s2 = new Socio("Martina", "Pérez", 20, true);
        Socio s3 = new Socio("Pablo", "Blanco", 17, false);
        Socio s4 = new Socio("María", "Blanco", 16, false);
        Socio s5 = new Socio("Pedro", "Picapiedra", 20, false);
        club.agregarSocio(s1);
        club.agregarSocio(s2);
        club.agregarSocio(s3);
        club.agregarSocio(s4);
        club.agregarSocio(s5);

        System.out.println("Socios:");
        System.out.println(club);

        // PRUEBA DE SERVICIOS
        // a) Socios con cuota impaga, ordenados primero por apellido y luego por nombre
        System.out.println("\na) Socios con cuota impaga, ordenados primero por apellido y luego por nombre:");
        Condicion condCuota = new CondicionCuota(false);
        Comparator<Socio> compNombre = new ComparadorNombre();
        Comparator<Socio> compApellido = new ComparadorApellido();
        ArrayList<Socio> busqueda = club.buscar(condCuota, new ComparadorCompuesto(compNombre, compApellido));
        club.imprimirLista(busqueda);

        // b) Todos los socios menores de edad, ordenados por edad
        System.out.println("\nb) Todos los socios menores de edad, ordenados por edad:");
        Condicion condEdad = new CondicionEdad(18);
        Comparator<Socio> compEdad = new ComparadorEdad();
        busqueda = club.buscar(condEdad, compEdad);
        club.imprimirLista(busqueda);

        // c) Búsqueda y órden segun alquiler de determinada cancha
        System.out.println("\nc) Búsqueda y ordenamiento según alquiler de cancha 13:");

        // Se alquilan canchas a los socios
        Alquiler a1 = new Alquiler(LocalDate.of(2023, 2, 20), 13, 500.0);
        Alquiler a2 = new Alquiler(LocalDate.of(2023, 2, 27), 13, 600.0);
        Alquiler a3 = new Alquiler(LocalDate.of(2023, 2, 23), 13, 1000.0);
        Alquiler a4 = new Alquiler(LocalDate.of(2023, 2, 25), 9, 400.0);
        Alquiler a5 = new Alquiler(LocalDate.of(2023, 2, 22), 10, 400.0);
        Alquiler a6 = new Alquiler(LocalDate.of(2023, 2, 20), 7, 600.0);
        Alquiler a7 = new Alquiler(LocalDate.of(2023, 2, 13), 2, 1000.0);

        s1.alquilarCancha(a1);
        s1.alquilarCancha(a2);
        s2.alquilarCancha(a3);
        s2.alquilarCancha(a4);
        s3.alquilarCancha(a5);
        s4.alquilarCancha(a6);
        s5.alquilarCancha(a7);

        Condicion condCancha = new CondicionCancha(13);
        Comparator<Socio> compCancha = new ComparadorCancha(13);
        busqueda = club.buscar(condCancha, compCancha);
        club.imprimirLista(busqueda);

        // d) Búsqueda y ordenamiento por precio de alquiler y cuota paga
        System.out.println("\nd) Búsqueda y ordenamiento por precio de alquiler y cuota paga:");
        Condicion condPagoMayor = new CondicionPago(0);
        Comparator<Socio> compCuotaPaga = new ComparadorCuota();
        busqueda = club.buscar(condPagoMayor, new ComparadorCompuesto(compCuotaPaga, compApellido));
        club.imprimirLista(busqueda);
    }
}
