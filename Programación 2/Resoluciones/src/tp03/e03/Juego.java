package tp03.e03;

public class Juego {
    // Atributos
    private Jugador j1;
    private Jugador j2;
    private Mazo mazo;
    private int cantidadRondas;

    // Constructores
    public Juego(Jugador j1, Jugador j2, Mazo mazo, int cantidadRondas) {
        this.j1 = j1;
        this.j2 = j2;
        this.mazo = mazo;
        this.cantidadRondas = cantidadRondas;
    }

    // Métodos
    public Jugador getJ1() {
        return j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public int getCantidadRondas() {
        return cantidadRondas;
    }

    public void setCantidadRondas(int cantidadRondas) {
        this.cantidadRondas = cantidadRondas;
    }

    public void jugar() {
        for (int i = 1; i <= cantidadRondas; i++) {
            System.out.println("RONDA " + i);

            // Los jugadores sacan una carta
            j1.sacarCarta(this.mazo);
            j2.sacarCarta(this.mazo);

            // Se imprimen los personajes obtenidos
            System.out.println("Personaje de " + j1.getNombre() + ": "
                    + j1.getPersonajeElegido().getNombreSuperheroe());
            System.out.println("Personaje de " + j2.getNombre() + ": "
                    + j2.getPersonajeElegido().getNombreSuperheroe());

            // Se comparan las características y se actualiza el puntaje
            int valor1 = j1.getPersonajeElegido().getValorCaracteristica(Main.CARACTERISTICA);
            int valor2 = j2.getPersonajeElegido().getValorCaracteristica(Main.CARACTERISTICA);

            if (valor1 > valor2)
                j1.incrementarPunto();
            else if (valor2 > valor1)
                j2.incrementarPunto();

            // Los jugadores vuelven a colocar la carta en el mazo
            j1.devolverCarta();
            j2.devolverCarta();
        }

        // Se imprimen los puntajes y el ganador, en caso de haberlo
        System.out.println("Puntos " + j1.getNombre() + ": " + j1.getPuntos());
        System.out.println("Puntos " + j2.getNombre() + ": " + j2.getPuntos());

        if (determinarGanador(j1, j2) != null)
            System.out.println("Ganador: " + determinarGanador(j1, j2).getNombre());
        else
            System.out.println("Empate");
    }

    public Jugador determinarGanador(Jugador j1, Jugador j2) {
        if (j1.getPuntos() > j2.getPuntos())
            return j1;
        else if (j2.getPuntos() > j1.getPuntos())
            return j2;
        else
            return null;
    }
}
