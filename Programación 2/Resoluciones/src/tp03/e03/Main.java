package tp03.e03;

public class Main {
    public static final int RONDAS = 10;
    public static final String CARACTERISTICA = "Fuerza";

    public static void main(String[] args) {
        // Se crean personajes y características
        Personaje personaje1 = new Personaje("Héroe", "Clark Kent", "Superman");
        personaje1.agregarCaracteristica(new Caracteristica("Fuerza", 2000));
        personaje1.agregarCaracteristica(new Caracteristica("Velocidad", 1200));

        Personaje personaje2 = new Personaje("Villano", "Lex Luthor", "Lex Luthor");
        personaje2.agregarCaracteristica(new Caracteristica("Fuerza", 400));
        personaje2.agregarCaracteristica(new Caracteristica("Velocidad", 800));

        Personaje personaje3 = new Personaje("Héroe", "Bruce Wayne", "Batman");
        personaje3.agregarCaracteristica(new Caracteristica("Fuerza", 1100));
        personaje3.agregarCaracteristica(new Caracteristica("Velocidad", 400));

        Personaje personaje4 = new Personaje("Villano", "Jack White", "Joker");
        personaje4.agregarCaracteristica(new Caracteristica("Fuerza", 1000));
        personaje4.agregarCaracteristica(new Caracteristica("Velocidad", 1100));

        // Se crea un mazo y se agregan los personajes al mismo
        Mazo mazo = new Mazo();
        mazo.agregarPersonaje(personaje1);
        mazo.agregarPersonaje(personaje2);
        mazo.agregarPersonaje(personaje3);
        mazo.agregarPersonaje(personaje4);

        // Se crean los jugadores
        Jugador j1 = new Jugador("Juan");
        Jugador j2 = new Jugador("Pedro");

        // Se crea y ejecuta el juego
        Juego juego = new Juego(j1, j2, mazo, RONDAS);
        juego.jugar();
    }
}
