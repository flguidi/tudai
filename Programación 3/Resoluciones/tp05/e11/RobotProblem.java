package tp05.e11;

import java.util.ArrayList;
import java.util.List;

/**
 * El robot de limpieza necesita volver desde su posición actual hasta su base de carga.
 * Dado que al robot le queda poca batería, desea encontrar el camino más corto.
 * El robot dispone de un mapa de la casa representado como una matriz, donde cada celda
 * es una posición de la casa. La matriz posee un 0 si la celda está vacía, o un 1 si la
 * celda presenta algún obstáculo (por ejemplo, un mueble). Se desea encontrar entonces
 * el camino más corto considerando que:
 * 1) Desde una celda solo se puede mover a las celdas contiguas (izquierda, derecha,
 * arriba y abajo); y
 * 2) El robot sólo puede caminar por celdas libres (es decir, sin obstáculos).
 */
public class RobotProblem {

    private static final int[][] MOVEMENTS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int EMPTY_CELL = 0;
    private static final int OBSTACLE = 1;

    private int[][] house;
    private boolean[][] visited;
    private List<int[]> shortestPath;

    /**
     * Encuentra el camino más corto entre dos puntos en la matriz.
     *
     * @param house  Matriz que representa el mapa de la casa (0: celda libre, 1: obstáculo).
     * @param startX Posición inicial en el eje X.
     * @param startY Posición inicial en el eje Y.
     * @param endX   Posición objetivo en el eje X.
     * @param endY   Posición objetivo en el eje Y.
     * @return Una lista de coordenadas que representan el camino más corto.
     */
    public List<int[]> findShortestPath(int[][] house, int startX, int startY, int endX, int endY) {
        this.house = house;

        if (outOfBounds(startX, startY) || outOfBounds(endX, endY)) {
            return new ArrayList<>();
        }

        if (house[startX][startY] == OBSTACLE || house[endX][endY] == OBSTACLE) {
            throw new IllegalArgumentException("ERROR: Hay obstáculos en el punto de partida y/o llegada.");
        }

        visited = new boolean[house.length][house[0].length];
        shortestPath = new ArrayList<>();
        List<int[]> path = new ArrayList<>();

        // Se marca la casilla de inicio como visitada y se agrega al camino
        visited[startX][startY] = true;
        path.add(new int[]{startX, startY});

        // Búsqueda recursiva del camino más corto
        backtrack(startX, startY, endX, endY, path);

        return shortestPath;
    }

    /**
     * Realiza la búsqueda del camino más corto mediante la técnica de backtracking.
     *
     * @param currentX Posición actual en el eje X (fila).
     * @param currentY Posición actual en el eje Y (columna).
     * @param endX     Posición objetivo en el eje X (fila).
     * @param endY     Posición objetivo en el eje Y (columna).
     * @param path     Lista que representa el camino actual desde el punto de inicio.
     */
    private void backtrack(int currentX, int currentY, int endX, int endY, List<int[]> path) {
        // Condición de corte: Si se llega a la celda destino
        if (currentX == endX && currentY == endY) {
            // Si el camino actual es el más corto hasta el momento, se actualiza la solución
            if (path.size() < shortestPath.size() || shortestPath.isEmpty()) {
                shortestPath = new ArrayList<>(path);
            }
            return;
        }

        // Se exploran las celdas contiguas
        for (int[] movement : MOVEMENTS) {
            // Coordenadas de la celda adyacente
            int newX = currentX + movement[0];
            int newY = currentY + movement[1];

            // Se verifica si la celda puede ser visitada
            if (!outOfBounds(newX, newY) && house[newX][newY] == EMPTY_CELL && !visited[newX][newY]) {
                // Se marca la casilla actual como visitada y se agrega al camino
                visited[newX][newY] = true;
                path.add(new int[]{newX, newY});

                // Llamada recursiva sobre celda adyacente
                backtrack(newX, newY, endX, endY, path);

                // Se deshace el último paso (backtracking)
                visited[newX][newY] = false;
                path.removeLast();
            }
        }
    }

    /**
     * Verifica si una posición está fuera de los límites de la matriz.
     *
     * @param x Coordenada en el eje X (fila).
     * @param y Coordenada en el eje Y (columna).
     * @return {@code true} si la posición está fuera de los límites, {@code false} en caso contrario.
     */
    private boolean outOfBounds(int x, int y) {
        return x < 0 || x >= house.length || y < 0 || y >= house[0].length;
    }

}
