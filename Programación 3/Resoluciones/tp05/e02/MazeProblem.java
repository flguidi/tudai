package tp05.e02;

import java.util.ArrayList;
import java.util.List;

/**
 * Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
 * cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
 * y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
 * camino la suma de los valores naturales de las casillas por las que pasa.
 * Idea: podría representarse el laberinto como una matriz de objetos, donde cada objeto tiene el valor
 * natural, y cuatro booleanos, uno para cada dirección a la que se permite ir desde allí.
 */
public class MazeProblem {

    private final Tile[][] maze;        // Matriz de casilleros que representa el laberinto
    private final Path shortestPath;    // Lista de casilleros que representa el camino más corto encontrado

    public MazeProblem(Tile[][] maze) {
        if (maze == null) {
            throw new IllegalArgumentException("ERROR: El laberinto no puede ser nulo.");
        } else if (maze.length == 0 || maze[0].length == 0) {
            throw new IllegalArgumentException("ERROR: Las dimensiones del laberinto deben ser mayores que 0.");
        }

        this.maze = maze;
        this.shortestPath = new Path();
    }

    /**
     * Encuentra el camino más corto entre la entrada y la salida del laberinto.
     * Utiliza un algoritmo de backtracking (búsqueda en profundidad).
     *
     * @param entryRow Fila de la entrada del laberinto.
     * @param entryCol Columna de la entrada del laberinto.
     * @param exitRow  Fila de la salida del laberinto.
     * @param exitCol  Columna de la salida del laberinto.
     * @return El camino más corto encontrado desde la entrada hasta la salida.
     * @throws IllegalArgumentException Si las coordenadas de la entrada o salida son inválidas.
     */
    public Path findShortestPath(int entryRow, int entryCol, int exitRow, int exitCol) {
        if (outOfBounds(entryRow, entryCol) || outOfBounds(exitRow, exitCol)) {
            throw new IllegalArgumentException("ERROR: Las coordenadas no son válidas.");
        }

        Tile entry = maze[entryRow][entryCol];
        Tile exit = maze[exitRow][exitCol];
        Path path = new Path();

        // Se comienza con el casillero de entrada
        entry.setVisited(true);
        path.addTile(entry);

        // Llamada recursiva
        backtrack(entry, exit, path);

        return shortestPath;
    }

    /**
     * Procedimiento recursivo que implementa el algoritmo de backtracking para encontrar el camino más corto.
     *
     * @param current El casillero actual en la búsqueda.
     * @param exit    El casillero de salida.
     * @param path    El camino que se está construyendo.
     */
    public void backtrack(Tile current, Tile exit, Path path) {
        // Si se llega al casillero destino, se procesa el resultado
        if (current.equals(exit)) {
            shortestPath.clear();
            shortestPath.addAllTiles(path.getTiles());
        }
        // Sino, se visitan los casilleros adyacentes
        else {
            for (Tile adjacent : getAdjacentTiles(current.getRow(), current.getCol())) {
                adjacent.setVisited(true);  // Se marca como visitado
                path.addTile(adjacent);     // Se agrega al camino actual

                if (path.getTotalValue() < shortestPath.getTotalValue() || shortestPath.getTiles().isEmpty()) { // Poda
                    backtrack(adjacent, exit, path); // Llamada recursiva
                }

                // Retroceso
                adjacent.setVisited(false); // Se marca como no visitado
                path.removeLastTile();      // Se elimina del camino actual
            }
        }
    }

    /**
     * Verifica si las coordenadas están fuera de los límites del laberinto.
     *
     * @param row Fila de la coordenada.
     * @param col Columna de la coordenada.
     * @return {@code true} si la coordenada está fuera de los límites del laberinto, {@code false} en caso contrario.
     */
    private boolean outOfBounds(int row, int col) {
        return (row < 0 || row >= maze.length) || (col < 0 || col >= maze[0].length);
    }

    /**
     * Obtiene los casilleros adyacentes a un casillero dado, es decir, aquellos a los que se puede mover.
     *
     * @param row Fila del casillero actual.
     * @param col Columna del casillero actual.
     * @return Una lista de casilleros adyacentes que se pueden visitar.
     */
    private List<Tile> getAdjacentTiles(int row, int col) {
        Tile tile = maze[row][col];
        List<Tile> tiles = new ArrayList<>();

        // Casillero norte
        if (!outOfBounds(row - 1, col) && tile.canGoNorth()) {
            tiles.add(maze[row - 1][col]);
        }

        // Casillero sur
        if (!outOfBounds(row + 1, col) && tile.canGoSouth()) {
            tiles.add(maze[row + 1][col]);
        }

        // Casillero este
        if (!outOfBounds(row, col + 1) && tile.canGoEast()) {
            tiles.add(maze[row][col + 1]);
        }

        // Casillero oeste
        if (!outOfBounds(row, col - 1) && tile.canGoWest()) {
            tiles.add(maze[row][col - 1]);
        }

        return tiles;
    }

}
