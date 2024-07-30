package tp03.e04;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Se crea una agenda
        AgendaCelular agenda = new AgendaCelular();

        // Se agregan contactos
        LocalDate fechaNacimiento1 = LocalDate.of(1978, 8, 15);
        agenda.agendarContacto(new Contacto("Pedro", "Gómez", "+9 58 15-12345678", fechaNacimiento1,
                "Los ombúes 1234", "juanperez@mail.com"));

        LocalDate fechaNacimiento2 = LocalDate.of(1990, 2, 20);
        agenda.agendarContacto(new Contacto("Pedro", "Gómez", "+9 58 15-12345678", fechaNacimiento2,
                "Los cedros 2345", "pedrogomez@mail.com"));

        LocalDate fechaNacimiento3 = LocalDate.of(1992, 6, 3);
        agenda.agendarContacto(new Contacto("Lautaro", "Martínez", "+9 58 15-12121212", fechaNacimiento3,
                "Los pinos 3456", "lautaromartinez@mail.com"));

        System.out.println(agenda);
    }
}
