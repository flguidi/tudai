package tp05.e03;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;

        int target = 5;

        SubsetSumProblem ssp = new SubsetSumProblem();

        System.out.println("Problema de la suma de subjuntos:");
        System.out.println("Conjunto: " + Arrays.toString(numbers));
        System.out.println("Objetivo: " + target);

        System.out.print("Subjuntos: ");
        for (List<Integer> solution : ssp.findSubsets(numbers, target)) {
            System.out.print(solution + " ");
        }
        System.out.print("\n");
    }

}
