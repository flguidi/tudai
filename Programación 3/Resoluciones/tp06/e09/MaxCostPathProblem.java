package tp06.e09;

public class MaxCostPathProblem {

    private int[][] matrix;
    private boolean[][] visited;

    /**
     * Encuentra el camino de mayor costo en una matriz, desde la celda de origen hasta la celda de destino.
     * El costo del camino se mide sumando los valores de las celdas visitadas.
     *
     * @param matrix   La matriz de enteros que representa el mapa de costos.
     * @param startRow La fila de la celda de inicio.
     * @param startCol La columna de la celda de inicio.
     * @param endRow   La fila de la celda de destino.
     * @param endCol   La columna de la celda de destino.
     * @return El objeto {@link MaxCostPath} que representa el camino de mayor costo desde el origen hasta el destino,
     *         o null si no existe un camino válido.
     */
    public MaxCostPath findMaxCostPath(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        this.matrix = matrix;

        // Se verifica que las coordendas estén dentro de la matriz
        if (outOfBounds(startRow, endRow) || outOfBounds(startCol, endCol)) {
            return null;
        }

        MaxCostPath solution = new MaxCostPath();
        visited = new boolean[matrix.length][matrix[0].length];

        // Se empieza por la casilla de entrada
        visited[startRow][startCol] = true;
        solution.addCell(new int[]{startRow, startCol}, matrix[startRow][startCol]);

        int row = startRow;
        int col = startCol;

        while ((row != endRow || col != endCol) && getMaxCostAdjacent(row, col) != null) {
            visited[row][col] = true;

            // Se busca el adyacente de mayor costo
            int[] adjacent = getMaxCostAdjacent(row, col);

            // Si se encontró un adyacente, se agrega a la solución
            if (adjacent != null) {
                // Se actualizan coordenadas
                row = adjacent[0];
                col = adjacent[1];

                // Se agrega a la solución
                solution.addCell(adjacent, matrix[row][col]);
            }
        }

        // Verifica si se llegó a la casilla destino
        if (row == endRow && col == endCol) {
            return solution;
        }

        return null; // No se encontró el camino
    }

    /**
     * Busca el adyacente con el mayor costo desde la celda dada.
     * Los movimientos válidos son hacia las celdas adyacentes (arriba, abajo, izquierda, derecha) con un costo
     * mayor al de la celda actual.
     *
     * @param row La fila de la celda actual.
     * @param col La columna de la celda actual.
     * @return Un arreglo con las coordenadas de la celda adyacente de mayor costo, o null si no existe tal celda.
     */
    private int[] getMaxCostAdjacent(int row, int col) {
        int[] maxCostAdjacent = null;
        int maxCost = matrix[row][col];

        if (canVisitCell(row - 1, col, maxCost)) { // Arriba
            maxCost = matrix[row - 1][col];
            maxCostAdjacent = new int[]{row - 1, col};
        }
        if (canVisitCell(row + 1, col, maxCost)) { // Abajo
            maxCost = matrix[row + 1][col];
            maxCostAdjacent = new int[]{row + 1, col};
        }
        if (canVisitCell(row, col - 1, maxCost)) { // Izquierda
            maxCost = matrix[row][col - 1];
            maxCostAdjacent = new int[]{row, col - 1};
        }
        if (canVisitCell(row, col + 1, maxCost)) { // Derecha
            maxCostAdjacent = new int[]{row, col + 1};
        }

        return maxCostAdjacent;
    }

    /**
     * Verifica si una celda puede ser visitada, es decir, si no está fuera de los límites,
     * no ha sido visitada previamente, y su valor es mayor que el de la celda actual.
     *
     * @param row         La fila de la celda que se quiere verificar.
     * @param col         La columna de la celda que se quiere verificar.
     * @param currentCost El costo de la celda actual.
     * @return {@code true} si la celda puede ser visitada, {@code false} de lo contrario.
     */
    private boolean canVisitCell(int row, int col, int currentCost) {
        return !outOfBounds(row, col) && !visited[row][col] && matrix[row][col] > currentCost;
    }

    /**
     * Verifica si una celda está fuera de los límites de la matriz.
     *
     * @param row La fila de la celda a verificar.
     * @param col La columna de la celda a verificar.
     * @return {@code true} si la celda está fuera de los límites, {@code false} de lo contrario.
     */
    private boolean outOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length;
    }

}
