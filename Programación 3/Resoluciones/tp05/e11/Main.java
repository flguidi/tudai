package tp05.e11;

import java.util.List;
import java.util.Random;

public class Main {

    private static final int SIZE = 5;
    private static final int EMPTY_CELL = 0;
    private static final int OBSTACLE = 1;
    private static final float OBSTACLE_PROBABILITY = 0.8f;

    public static void main(String[] args) {
        // Se crea la casa (matriz con 0s y 1s)
        int[][] house = new int[SIZE][SIZE];
        createHouse(house);
        System.out.println("Mapa de la casa:");
        printHouse(house);

        // Posición de origen y destino del robot
        int x1 = 0;
        int y1 = 0;
        int x2 = SIZE - 1;
        int y2 = SIZE - 1;

        // Se busca el camino de retorno más corto
        RobotProblem rp = new RobotProblem();
        List<int[]> shortestPath;
        shortestPath = rp.findShortestPath(house, x1, y1, x2, y2);

        if (!shortestPath.isEmpty()) {
            System.out.println("\nCamino más corto:");
            for (int[] path : shortestPath) {
                System.out.print("(" + path[0] + "," + path[1] + ") ");
            }
            System.out.println();
        } else {
            System.out.println("\nNo se encontró un camino entre (" + x1 + "," + y1 + ") y " + "(" + x2 + "," + y2 + ").");
        }
    }

    private static void createHouse(int[][] house) {
        Random r = new Random();
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < house[i].length; j++) {
                house[i][j] = r.nextFloat() > OBSTACLE_PROBABILITY ? OBSTACLE : EMPTY_CELL;
            }
        }
    }

    private static void printHouse(int[][] house) {
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < house[i].length; j++) {
                System.out.print(house[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
