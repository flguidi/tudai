package tp05.e07;

public class Main {

    public static void main(String[] args) {
        System.out.println("CUADRADO MÁGICO");
        int N = 3;
        System.out.println("N = " + N);

        MagicSquareProblem msp = new MagicSquareProblem();
        int[][] solution = msp.solve(N);

        System.out.println("Intentando colocar números naturales entre 1 y " + N + "x" + N + ":");
        if (solution != null) {
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution[i].length; j++) {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No existe solución.");
        }
    }

}
