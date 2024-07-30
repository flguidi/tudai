package tp04.e04;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Se instancia una selección de futbol
        SeleccionFutbol seleccionArgentina = new SeleccionFutbol("Selección Argentina");

        // Se instancian un jugador, un entrenador y un masajista
        Jugador jugador = new Jugador("Lionel", "Messi", "AR1235678",
                LocalDate.of(1987, 6, 24), "Delantero",
                true, 104
        );

        Entrenador entrenador = new Entrenador(
                "Lionel", "Scaloni", "AR23456789",
                LocalDate.of(1978, 5, 16), "1234"
        );

        Masajista masajista = new Masajista(
                "Juan", "Pérez", "AR34567890",
                LocalDate.of(1980, 6, 20), "Masajista deportivo", 12
        );

        // Se agregan los integrantes a la selección
        seleccionArgentina.agregarIntegrante(jugador);
        seleccionArgentina.agregarIntegrante(entrenador);
        seleccionArgentina.agregarIntegrante(masajista);

        // Se modifica el estado de algunos integrantes y se verifica si están disponibles
        jugador.setEstado("En concentración");
        entrenador.setEstado("Viajando");

        System.out.println(jugador);
        System.out.println("Está disponible: " + jugador.estaDisponible());

        System.out.println(entrenador);
        System.out.println("Está disponible: " + entrenador.estaDisponible());

        System.out.println(masajista);
        System.out.println("Está disponible: " + masajista.estaDisponible());
    }
}
