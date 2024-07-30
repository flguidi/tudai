package tp07.e04;

import tp07.e04.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // Se instancia un juego
        JuegoGolosinas juego = new JuegoGolosinas();

        // Se crean y agregan tableros al juego
        Tablero tablero = new Tablero(1, 500);
        juego.agregarTablero(tablero);

        // Se crean y agregan fichas al tablero
        tablero.agregarFicha(new Ficha("Chocolate", 1, 1, 0));
        tablero.agregarFicha(new Ficha("Piedra", 6, 1, 0));
        tablero.agregarFicha(new Ficha("Caramelo a rayas", 1, 1, 10));
        tablero.agregarFicha(new Ficha("Torta", 4, 8, 4));

        // Se instancia una ficha especial y se agrega al tablero
        Ficha chicle = new FichaEspecial("Chicle", 10, 4);
        tablero.agregarFicha(chicle);

        // Se imprime información del juego y el tablero
        System.out.println(juego);
        System.out.println("\n" + tablero.obtenerInformacion());

        // Se imprime la información del chicle, para observar el cálculo de poder
        System.out.println("\n" + chicle.obtenerInformacion());

        // Se realizan búsquedas
        System.out.println("\nBUSQUEDAS");
        System.out.print("Fichas con poder de destrucción mayor que 2: ");
        System.out.println(tablero.buscarFichas(new CondicionPoder(2)));

        System.out.print("Fichas con espacio mayor que 4: ");
        System.out.println(tablero.buscarFichas(new CondicionEspacio(4)));

        System.out.print("Fichas con fortaleza mayor que 5: ");
        System.out.println(tablero.buscarFichas(new CondicionFortaleza(5)));
    }
}
