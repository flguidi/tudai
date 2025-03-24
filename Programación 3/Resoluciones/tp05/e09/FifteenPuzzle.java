package tp05.e09;

import java.util.*;

/**
 * Juego del 15 (Fifteen Puzzle):
 * Dado un tablero de 4 x 4, en cuyas casillas se encuentran desordenados los números enteros del 1
 * al 15 y una casilla desocupada en una posición inicial dada, determinar una secuencia de pasos tal
 * que, intercambiando números contiguos (horizontal y verticalmente) con la casilla desocupada, los
 * números en el tablero queden ordenados y la casilla desocupada quede en la posición (4,4).
 */
public class FifteenPuzzle {

    private static final int SIZE = 4;
    private static final int[][] MOVEMENTS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int[][] TARGET = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    /**
     * Resuelve el juego del 15 utilizando BFS para encontrar la secuencia mínima de movimientos.
     *
     * @param board El tablero inicial representado como una matriz de 4 x 4.
     * @throws IllegalArgumentException Si el tablero no es de tamaño 4 x 4.
     */
    public void solve(int[][] board) {
        if (board == null || board.length != SIZE || board[0].length != SIZE) {
            throw new IllegalArgumentException("El tablero debe ser de 4 x 4");
        }

        String targetState = boardToString(TARGET);
        String initialState = boardToString(board);

        System.out.println("Tablero original:");
        printBoard(board);

        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int[] emptyTile = findEmptyTile(board);
        queue.offer(new Node(initialState, emptyTile[0], emptyTile[1], 0, null));
        visited.add(initialState);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.state.equals(targetState)) {
                System.out.println();
                printSolutionPath(current); // Imprime el camino hacia la solución
                System.out.println("Solución encontrada en " + current.moves + " movimientos.");
                return;
            }

            int[][] currentBoard = stringToBoard(current.state);

            for (int[] movement : MOVEMENTS) {
                int newRow = current.emptyRow + movement[0];
                int newCol = current.emptyCol + movement[1];

                if (isInsideBoard(newRow, newCol)) {
                    swap(currentBoard, current.emptyRow, current.emptyCol, newRow, newCol);
                    String newState = boardToString(currentBoard);

                    if (!visited.contains(newState)) {
                        queue.offer(new Node(newState, newRow, newCol, current.moves + 1, current));
                        visited.add(newState);
                    }

                    swap(currentBoard, newRow, newCol, current.emptyRow, current.emptyCol);
                }
            }
        }

        System.out.println("No se encontró solución.");
    }

    /**
     * Verifica si una posición está dentro de los límites del tablero.
     *
     * @param row Fila a verificar.
     * @param col Columna a verificar.
     * @return {@code true} si la posición está dentro del tablero, {@code false} en caso contrario.
     */
    private boolean isInsideBoard(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    /**
     * Encuentra la posición de la casilla vacía (0) en el tablero.
     *
     * @param board El tablero.
     * @return Un arreglo de dos elementos donde el primer elemento es la fila y el segundo es la columna.
     * @throws IllegalArgumentException Si el tablero no contiene una casilla vacía.
     */
    private int[] findEmptyTile(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("El tablero no contiene una casilla vacía (0).");
    }

    /**
     * Intercambia dos casillas en el tablero.
     *
     * @param board El tablero.
     * @param row1  Fila de la primera casilla.
     * @param col1  Columna de la primera casilla.
     * @param row2  Fila de la segunda casilla.
     * @param col2  Columna de la segunda casilla.
     */
    private void swap(int[][] board, int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
    }

    /**
     * Convierte un tablero a una representación de cadena.
     *
     * @param board El tablero.
     * @return Una cadena que representa el estado del tablero.
     */
    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int value : row) {
                sb.append(value).append(",");
            }
        }
        return sb.toString();
    }

    /**
     * Convierte una representación de cadena a un tablero.
     *
     * @param state La representación de cadena del tablero.
     * @return Un tablero como matriz de 4 x 4.
     */
    private int[][] stringToBoard(String state) {
        int[][] board = new int[SIZE][SIZE];
        String[] values = state.split(",");
        int index = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(values[index++]);
            }
        }

        return board;
    }

    /**
     * Imprime un tablero en la consola.
     *
     * @param board El tablero a imprimir.
     */
    private void printBoard(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Imprime el camino desde el estado inicial hasta el estado objetivo.
     *
     * @param node El nodo que representa el estado objetivo.
     */
    private void printSolutionPath(Node node) {
        List<int[][]> path = new ArrayList<>();
        while (node != null) {
            path.add(stringToBoard(node.state));
            node = node.parent;
        }
        Collections.reverse(path);
        System.out.println("Camino hacia la solución:");
        for (int[][] board : path) {
            printBoard(board);
            System.out.println();
        }
    }

    /**
     * Clase interna que representa un nodo en la búsqueda BFS.
     */
    private static class Node {
        String state; // Representación del estado del tablero
        int emptyRow; // Fila de la casilla vacía
        int emptyCol; // Columna de la casilla vacía
        int moves;    // Número de movimientos realizados para alcanzar este estado
        Node parent;  // Nodo padre para reconstruir el camino a la solución

        Node(String state, int emptyRow, int emptyCol, int moves, Node parent) {
            this.state = state;
            this.emptyRow = emptyRow;
            this.emptyCol = emptyCol;
            this.moves = moves;
            this.parent = parent;
        }
    }

}
