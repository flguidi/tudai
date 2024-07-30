package tp02.e02;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Se crea una agenda con un límite de 12 reuniones
        Agenda agenda = new Agenda(12);

        // Se agrega una reunión en la agenda
        System.out.println("Se agrega una reunión:");
        LocalDateTime fechaInicio1 = LocalDateTime.of(2023, 8, 20, 17, 30, 0);
        LocalDateTime fechaFin1 = LocalDateTime.of(2023, 8, 20, 19, 30, 0);
        agenda.agregarReunion(new Reunion("Reunión 1", "Lugar 1", fechaInicio1, fechaFin1, 10));

        // Se agregan 5 participantes a la reunión
        agenda.getReunion(1).agregarParticipante(new Contacto("Contacto 1", "1111-1111", "ejemplo1@mail"));
        agenda.getReunion(1).agregarParticipante(new Contacto("Contacto 2", "2222-2222", "ejemplo2@mail"));
        agenda.getReunion(1).agregarParticipante(new Contacto("Contacto 3", "3333-3333", "ejemplo3@mail"));
        agenda.getReunion(1).agregarParticipante(new Contacto("Contacto 4", "4444-4444", "ejemplo4@mail"));
        agenda.getReunion(1).agregarParticipante(new Contacto("Contacto 5", "5555-5555", "ejemplo5@mail"));

        // Impresión de información
        System.out.println(agenda.getReunion(1));

        // Se agrega otra reunión para verificar superposiciones
        System.out.println("Se intenta agregar otra reunion:");
        LocalDateTime fechaInicio2 = LocalDateTime.of(2023, 8, 20, 19, 0, 0);
        LocalDateTime fechaFin2 = LocalDateTime.of(2023, 8, 20, 20, 30, 0);
        agenda.agregarReunion(new Reunion("Reunión 2", "Lugar 2", fechaInicio2, fechaFin2, 10));
    }
}
