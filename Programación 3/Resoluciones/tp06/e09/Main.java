package tp06.e09;

public class Main {

    public static void main(String[] args) {
        // Matriz
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Matriz:");
        printMatrix(matrix);

        // Origen y destino
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        System.out.println("\nCamino de mayor costo entre (" + startRow + "," + startCol + ") y (" + endRow + "," + endCol + "):");

        // Camino de mayor costo
        MaxCostPathProblem mcpp = new MaxCostPathProblem();
        MaxCostPath path = mcpp.findMaxCostPath(matrix, startRow, startCol, endRow, endCol);
        if (path != null) {
            System.out.println(path);
        } else {
            System.out.println("No hay un camino válido entre (" + startRow + "," + startCol + ") y (" + endRow + "," + endCol + "):");
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
