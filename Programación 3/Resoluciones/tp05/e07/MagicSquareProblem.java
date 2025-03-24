package tp05.e07;

/**
 * Cuadrado mágico:
 * Dado un cuadrado de tamaño NxN, construir un algoritmo que ubique (si es posible) NxN números naturales
 * diferentes, entre 1 y K, siendo K un número natural mayor que NxN, de manera tal que la suma de las columnas
 * y de las filas sea igual que una constante S.
 */
public class MagicSquareProblem {

    private int N;           // Tamaño del tablero
    private int[][] square;  // El cuadrado de NxN
    private boolean[] used;  // Arreglo para verificar números usados
    private int S;           // Constante que deb ser igual en filas y columnas

    /**
     * Resuelve el problema del cuadrado mágico.
     *
     * @param N El tamaño del cuadrado (NxN).
     * @return La matriz de tamaño NxN que representa el cuadrado mágico, o null si no se encuentra una solución.
     */
    public int[][] solve(int N) {
        this.N = N;
        square = new int[N][N];
        used = new boolean[N * N + 1];
        S = (N * (N * N + 1)) / 2;

        if (backtrack(0, 0)) {
            return square;
        } else {
            return null;
        }
    }

    /**
     * Función booleana recursiva de backtracking para intentar llenar el cuadrado mágico.
     *
     * @param row La fila actual que estamos intentando llenar.
     * @param col La columna actual que estamos intentando llenar.
     * @return {@code true} si se encuentra una solución válida, {@code false} si no.
     */
    private boolean backtrack(int row, int col) {
        // Caso base: Si se colocaron todos los números, se verifica si la solución es válida
        if (row == N) {
            return verifySum();
        }

        // Se calcula la siguiente posición
        int nextCol = (col + 1) % N;
        int nextRow = (col == N - 1) ? row + 1 : row;

        // Se intenta colocar números naturales desde 1 hasta NxN en la posición (row, col) actual
        for (int num = 1; num <= N * N; num++) {
            // Si el número no ha sido usado
            if (!used[num]) {
                // Se asigna el número en la posición actual
                square[row][col] = num;
                used[num] = true;

                // Llamada recursiva
                if (backtrack(nextRow, nextCol)) {
                    return true;
                }

                // Se deshace la asignación (backtracking)
                square[row][col] = 0;
                used[num] = false;
            }
        }

        return false; // No se pudo colocar ningún número válido
    }

    // Función que verifica si la suma de las filas y columnas es la constante S
    private boolean verifySum() {
        // Verificar filas
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += square[i][j];
            }
            if (rowSum != S) {
                return false;
            }
        }

        // Verificar columnas
        for (int j = 0; j < N; j++) {
            int colSum = 0;
            for (int i = 0; i < N; i++) {
                colSum += square[i][j];
            }
            if (colSum != S) {
                return false;
            }
        }

        return true;
    }

}
