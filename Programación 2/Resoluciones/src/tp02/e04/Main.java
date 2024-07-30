package tp02.e04;

import java.time.LocalDateTime;

public class Main {
    public static final int PRECIO_FUTBOL = 400;
    public static final int PRECIO_PADDLE = 100;
    public static final int LIMITE_TURNOS = 50;
    public static final int LIMITE_USUARIOS = 20;
    public static final int LIMITE_CANCHAS = 10;

    public static void main(String[] args) {
        // Se crea el establecimiento
        Establecimiento establecimiento = new Establecimiento(
                "Establecimiento deportivo",
                LIMITE_USUARIOS,
                LIMITE_TURNOS,
                LIMITE_CANCHAS
        );

        // Se crean las canchas (2 de fútbol y 4 de paddle) y se agregan al establecimiento
        Cancha canchaFutbol1 = new Cancha("Futbol1", PRECIO_FUTBOL);
        Cancha canchaFutbol2 = new Cancha("Futbol2", PRECIO_FUTBOL);
        Cancha canchaPaddle1 = new Cancha("Paddle1", PRECIO_PADDLE);
        Cancha canchaPaddle2 = new Cancha("Paddle2", PRECIO_PADDLE);
        Cancha canchaPaddle3 = new Cancha("Paddle3", PRECIO_PADDLE);
        Cancha canchaPaddle4 = new Cancha("Paddle4", PRECIO_PADDLE);

        // Se agregan las canchas al establecimiento
        establecimiento.agregarCancha(canchaFutbol1);
        establecimiento.agregarCancha(canchaFutbol2);
        establecimiento.agregarCancha(canchaPaddle1);
        establecimiento.agregarCancha(canchaPaddle2);
        establecimiento.agregarCancha(canchaPaddle3);
        establecimiento.agregarCancha(canchaPaddle4);

        // Se crea un usuario y se agrega a la lista del establecimiento
        Usuario usuario = new Usuario("Juan Pérez", LIMITE_TURNOS);
        establecimiento.agregarUsuario(usuario);

        // Se crea un turno (turno1) y se hace la reserva para 'canchaFutbol1'
        LocalDateTime fecha1 = LocalDateTime.of(2023, 8, 20, 17, 30);

        Turno turno1 = new Turno(canchaFutbol1, fecha1, usuario);
        establecimiento.reservarTurno(turno1);

        // Se verifica si el usuario es socio
        System.out.println("Nombre de usuario: " + usuario.getNombre());
        System.out.println("Es socio: " + usuario.esSocio());
        System.out.println("Precio por turno (cancha de fútbol): " + turno1.calcularPrecio());

        // Se agregan reservas para determinar si el usuario es socio
        // Turno 2
        LocalDateTime fecha2 = LocalDateTime.of(2023, 8, 21, 21, 30);
        Turno turno2 = new Turno(canchaFutbol2, fecha2, usuario);
        establecimiento.reservarTurno(turno2);

        LocalDateTime fecha3 = LocalDateTime.of(2023, 8, 23, 16, 30);
        Turno turno3 = new Turno(canchaPaddle1, fecha3, usuario);
        establecimiento.reservarTurno(turno3);

        LocalDateTime fecha4 = LocalDateTime.of(2023, 8, 23, 16, 0);
        Turno turno4 = new Turno(canchaPaddle2, fecha4, usuario);
        establecimiento.reservarTurno(turno4);

        System.out.println("¿Ahora es socio?: " + usuario.esSocio());
        System.out.println("Precio por turno (cancha de fútbol): " + turno1.calcularPrecio());
    }
}
