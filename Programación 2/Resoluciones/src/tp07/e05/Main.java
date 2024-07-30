package tp07.e05;

import tp07.e05.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // Se instancia una plataforma de streaming
        PlataformaStreaming ps = new PlataformaStreaming();

        // Se instancian películas y se les añade información
        Pelicula p1 = new Pelicula(
                "Titanic",
                "Una película romántica sobre el desafortunado viaje del RMS Titanic.",
                "James Cameron",
                1997,
                195,
                13
        );

        p1.agregarGenero("Drama");
        p1.agregarGenero("Romance");
        p1.agregarActor("Leonardo DiCapio");
        p1.agregarActor("Kate Winslet");

        Pelicula p2 = new Pelicula(
                "El Padrino",
                "Un clásico del cine sobre la mafia italiana en Estados Unidos.",
                "Francis Ford Coppola",
                1972,
                175,
                18
        );

        p2.agregarGenero("Crimen");
        p2.agregarGenero("Drama");
        p2.agregarActor("Marlon Brando");
        p2.agregarActor("Al Pacino");

        System.out.println(p1.obtenerInformacion());
        System.out.println("\n" + p2.obtenerInformacion());

        // Se agregan las películas a la plataforma
        ps.agregarPelicula(p1);
        ps.agregarPelicula(p2);

        // 1. Se realizan búsquedas
        System.out.println("\n1. BUSQUEDAS");
        System.out.print("a. Búsqueda por título: ");
        System.out.println(ps.buscarPeliculas(new CondicionTitulo("Padrino")));

        System.out.print("b. Búsqueda por género: ");
        System.out.println(ps.buscarPeliculas(new CondicionGenero("Drama")));

        System.out.print("c. Búsqueda compuesta (actor y director): ");
        Condicion cond1 = new CondicionActor("Will Smith");
        Condicion cond2 = new CondicionDirector("Martin Scorsese");
        System.out.println(ps.buscarPeliculas(new CondicionAnd(cond1, new CondicionNot(cond2))));

        System.out.print("d. Búsqueda compuesta (año y duración): ");
        cond1 = new CondicionEstreno(2015);
        cond2 = new CondicionDuracion(95);
        System.out.println(ps.buscarPeliculas(new CondicionAnd(cond1, cond2)));

        // 2. Se verifica rentabilidad
        System.out.println("\n2. RENTABILIDAD");

        // Condición 1
        cond1 = new CondicionDuracion(120);
        cond2 = new CondicionNot(new CondicionGenero("Comedia"));

        System.out.print("'" + p1.getTitulo() + "' es rentable: ");
        System.out.println(p1.esRentable(new CondicionAnd(cond1, cond2)));

        System.out.print("'" + p2.getTitulo() + "' es rentable: ");
        System.out.println(p2.esRentable(new CondicionAnd(cond1, cond2)));

        // Condición 2
        cond1 = new CondicionNot(new CondicionEstreno(2017));
        cond2 = new CondicionGenero("Infantil");
        Condicion cond3 = new CondicionGenero("Documental");

        System.out.print("'" + p1.getTitulo() + "' es rentable: ");
        System.out.println(p1.esRentable(new CondicionOr(cond1, new CondicionOr(cond2, cond3))));

        System.out.print("'" + p2.getTitulo() + "' es rentable: ");
        System.out.println(p2.esRentable(new CondicionOr(cond1, new CondicionOr(cond2, cond3))));
    }
}
