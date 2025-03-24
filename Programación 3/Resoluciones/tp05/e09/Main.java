package tp05.e09;

public class Main {

    public static void main(String[] args) {
        int[][] board = {
                {5, 1, 2, 4},
                {0, 6, 3, 8},
                {9, 10, 7, 12},
                {13, 14, 11, 15}
        };

        System.out.println("Juego del 15:");
        FifteenPuzzle tsp = new FifteenPuzzle();
        tsp.solve(board);
    }

}
