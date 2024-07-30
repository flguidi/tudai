package tp07.e04;

import java.util.ArrayList;

public class JuegoGolosinas {
    // Atributos
    private ArrayList<Tablero> tableros;

    // Constructores
    public JuegoGolosinas() {
        this.tableros = new ArrayList<Tablero>();
    }

    // Métodos
    public void agregarTablero(Tablero tablero) {
        if (!tableros.contains(tablero) && tablero != null)
            tableros.add(tablero);
    }

    public void eliminarTablero(Tablero tablero) {
        tableros.remove(tablero);
    }

    @Override
    public String toString() {
        return "JUEGO DE GOLOSINAS\n" +
                "Tableros: " + tableros;
    }
}
