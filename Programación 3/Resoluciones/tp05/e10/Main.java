package tp05.e10;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {-7, -3, -2, -1, 5, 8};
        int n = 3;
        System.out.println("Conjunto original:\n" + Arrays.toString(numbers));

        ZeroSumSubsetsProblem zssp = new ZeroSumSubsetsProblem();
        List<List<Integer>> subsets = zssp.solve(n, numbers);

        if (!subsets.isEmpty()) {
            System.out.println("\nSubconjuntos de tamaño " + n + " que suman 0:");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
        } else {
            System.out.println("No hay subconjuntos que sumen 0.");
        }
    }

}
