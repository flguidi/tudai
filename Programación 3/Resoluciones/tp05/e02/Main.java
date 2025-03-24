package tp05.e02;

public class Main {

    public static void main(String[] args) {
        // Laberinto de 3x3
        Tile[][] maze = new Tile[3][3];

        maze[0][0] = new Tile(0, 0, 0, false, true, true, false); // Entrada
        maze[0][1] = new Tile(0, 1, 1, false, true, true, false);
        maze[0][2] = new Tile(0, 2, 8, false, true, false, false);

        maze[1][0] = new Tile(1, 0, 1, false, true, false, false);
        maze[1][1] = new Tile(1, 1, 6, false, true, false, false);
        maze[1][2] = new Tile(1, 2, 9, false, true, false, false);

        maze[2][0] = new Tile(2, 0, 2, false, false, false, false);
        maze[2][1] = new Tile(2, 1, 8, false, false, true, false);
        maze[2][2] = new Tile(2, 2, 0, false, false, false, false); // Salida

        // E
        // 0 → 1 → 8
        // ↓   ↓   ↓
        // 1   6   9
        // ↓   ↓   ↓
        // 2   8 → 0
        //         S

        // Solución al problema del laberinto
        MazeProblem mp = new MazeProblem(maze);
        int entryRow = 0;
        int entryCol = 0;
        int exitRow = 2;
        int exitCol = 2;

        System.out.println("Entrada: (" + entryRow + "," + entryCol + ")");
        System.out.println("Salida: (" + exitRow + "," + exitCol + ")");
        System.out.println(mp.findShortestPath(entryRow, entryCol, exitRow, exitCol));
    }

}
