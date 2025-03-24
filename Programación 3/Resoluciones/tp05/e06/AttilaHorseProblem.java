package tp05.e06;

import java.util.ArrayList;
import java.util.List;

/**
 * Caballo de Atila:
 * Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue directamente hacia el
 * jardín de NxN casillas. Empezó su paseo por una casilla cualquiera y volvió a ella, es decir hizo un
 * recorrido cerrado. No visitó dos veces una misma casilla, se movió de una casilla a otra vecina en forma
 * horizontal o vertical, pero nunca en diagonal. Por donde pisó el caballo, el pasto jamás volvió a crecer.
 * Luego de terminado el recorrido en algunas casillas todavía había pasto (señal de que en ellas no había
 * estado el caballo). Escribir un algoritmo que deduzca el recorrido completo que hizo el caballo.
 */
public class AttilaHorseProblem {

    private Tile[][] garden;
    private int remainingTiles;
    private List<List<String>> paths;

    public AttilaHorseProblem() {
        init();
    }

    /**
     * Inicializa el jardín, configurando las casillas y el número de casillas restantes.
     */
    private void init() {
        // Se crea una lista solución vacía
        paths = new ArrayList<>();

        // Se crea una matriz (jardín) de NxN con casillas con pasto
        int size = 4;
        garden = new Tile[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                garden[i][j] = Tile.GRASS;
            }
        }

        // Se marcan algunas casillas como no verificadas
        garden[0][0] = Tile.NOT_CHECKED;
        garden[0][1] = Tile.NOT_CHECKED;
        garden[0][2] = Tile.NOT_CHECKED;
        garden[0][3] = Tile.NOT_CHECKED;

        garden[1][0] = Tile.NOT_CHECKED;
        garden[1][1] = Tile.NOT_CHECKED;
        garden[1][2] = Tile.NOT_CHECKED;
        garden[1][3] = Tile.NOT_CHECKED;

        garden[2][0] = Tile.NOT_CHECKED;
        garden[2][1] = Tile.NOT_CHECKED;

        // Cantidad de casillas restantes (coincide con el número de casillas no verificadas)
        remainingTiles = 10;
    }

    /**
     * Encuentra los caminos que el caballo puede seguir para recorrer el jardín,
     * marcando las casillas sin repetir.
     *
     * @return Lista de caminos representados por las coordenadas de las casillas.
     */
    public List<List<String>> findPaths() {
        init();

        List<String> path = new ArrayList<>();
        int entryRow = 0;
        int entryCol = 0;

        backtrack(entryRow, entryCol, entryCol, entryRow, path);

        return paths;
    }

    /**
     * Procedimiento recursivo que explora todos los posibles caminos utilizando backtracking.
     *
     * @param currentRow Fila actual donde se encuentra el caballo.
     * @param currentCol Columna actual donde se encuentra el caballo.
     * @param exitRow    Fila de salida (en este caso, la misma que la fila de inicio).
     * @param exitCol    Columna de salida (en este caso, la misma que la columna de inicio).
     * @param path       Camino actual representado por una lista de coordenadas.
     */
    private void backtrack(int currentRow, int currentCol, int exitRow, int exitCol, List<String> path) {
        // Caso base: Se vuelve a la casilla de inicio
        if (currentRow == exitRow && currentCol == exitCol && garden[exitRow][exitCol] != Tile.NOT_CHECKED) {
            // Si no quedaron casillas por verificar, se agrega el camino actual a la solución
            if (remainingTiles == 0) {
                path.add("(" + currentRow + "," + currentCol + ")");
                paths.add(new ArrayList<>(path));
            }
            return;
        }

        // Se verifica si la casilla actual no puede ser visitada
        if (outOfBounds(currentRow, currentCol) || garden[currentRow][currentCol] != Tile.NOT_CHECKED) {
            return;
        }

        // Se marca la casilla como visitada y se agrega al camino
        garden[currentRow][currentCol] = Tile.CHECKED;
        path.add("(" + currentRow + "," + currentCol + ")");

        // Se resta una casilla de las restantes
        remainingTiles--;

        // Llamadas recursivas para explorar las 4 direcciones
        backtrack(currentRow - 1, currentCol, exitRow, exitCol, path); // Arriba
        backtrack(currentRow + 1, currentCol, exitRow, exitCol, path); // Abajo
        backtrack(currentRow, currentCol - 1, exitRow, exitCol, path); // Izquierda
        backtrack(currentRow, currentCol + 1, exitRow, exitCol, path); // Derecha

        // Deshacer cambios (backtracking)
        garden[currentRow][currentCol] = Tile.NOT_CHECKED;
        path.removeLast();
        remainingTiles++;
    }

    /**
     * Verifica si una casilla está fuera de los límites del jardín.
     *
     * @param row Fila de la casilla.
     * @param col Columna de la casilla.
     * @return {@code true} si la casilla está fuera de los límites, {@code false} en caso contrario.
     */
    private boolean outOfBounds(int row, int col) {
        return row < 0 || row >= garden.length || col < 0 || col >= garden[row].length;
    }

    /**
     * Imprime el estado actual del jardín.
     *
     * @return Representación en forma de cadena del jardín.
     */
    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                sb.append(garden[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Enum que representa los posibles estados de una casilla en el jardín.
     */
    public enum Tile {
        GRASS, CHECKED, NOT_CHECKED;

        @Override
        public String toString() {
            return switch (this) {
                case GRASS -> "G";        // Pasto
                case CHECKED -> "x";      // Casilla visitada
                case NOT_CHECKED -> "·";  // Casilla no visitada
            };
        }
    }

}
