package tp02.e05;

import java.time.LocalDateTime;

public class Main {
    public static final int LIMITE_PELUQUEROS = 4;
    public static final int LIMITE_TURNOS = 10;

    public static void main(String[] args) {
        // Se instancia una peluquería y se guarda en la variable 'peluqueria'
        Peluqueria peluqueria = new Peluqueria("Peluquería Central", LIMITE_PELUQUEROS);

        // Se instancia un peluquero y se guarda en la variable 'peluquero'
        Peluquero peluquero = new Peluquero("Pablo Rigazzi", LIMITE_TURNOS);

        // Se agrega el peluquero a la peluquería
        peluqueria.agregarPeluquero(peluquero);

        // Se crea un cliente y se guarda en la variable 'cliente'
        Cliente cliente = new Cliente("Juan Pérez", LIMITE_TURNOS);

        // Se crea un turnos
        Turno turno1 = new Turno(peluquero, cliente, LocalDateTime.of(2023, 5, 10, 17, 30, 0));
        Turno turno2 = new Turno(peluquero, cliente, LocalDateTime.of(2023, 6, 15, 16, 0, 0));

        // La peluquería registra el turno
        peluqueria.registrarTurno(turno1);
        peluqueria.registrarTurno(turno2);

        // Se muestra información por salida estándar
        System.out.println(peluqueria);
        System.out.println(peluquero);
        System.out.println(cliente);
        System.out.println(turno1);
        System.out.println(turno2);

        // Se verifica si el cliente es frecuente
        boolean esClienteFrecuente = cliente.esFrecuente();
        System.out.println("¿" + cliente.getNombre() + " es cliente frecuente? " + esClienteFrecuente);
    }
}
