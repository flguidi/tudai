package tp05.e03;

import java.util.ArrayList;
import java.util.List;

/**
 * Suma de subconjuntos:
 * Dados n números positivos distintos, se desea encontrar todas las combinaciones de esos números tal que la
 * suma sea igual a M.
 */
public class SubsetSumProblem {

    private List<List<Integer>> solutions;
    private int target;

    /**
     * Devuelve todas las combinaciones de subconjuntos cuya suma sea igual al objetivo.
     *
     * @param numbers   Un arreglo de números positivos distintos.
     * @param targetSum El número objetivo que debe alcanzarse con la suma de los elementos de los subconjuntos.
     * @return Una lista de listas, donde cada lista interna es un subconjunto cuya suma es igual a {@code targetSum}.
     */
    public List<List<Integer>> findSubsets(int[] numbers, int targetSum) {
        this.solutions = new ArrayList<>();
        this.target = targetSum;
        List<Integer> solution = new ArrayList<>();
        backtrack(0, 0, numbers, solution);
        return solutions;
    }

    /**
     * Procedimiento recursivo de backtracking para generar subconjuntos y verificar si su suma es igual al objetivo.
     *
     * @param index    El índice del número actual que se está considerando para ser incluido/excluido del subconjunto.
     * @param sum      La suma actual de los elementos del subconjunto.
     * @param numbers  El arreglo de números positivos que se están considerando.
     * @param solution La lista actual que representa el subconjunto que se está formando.
     */
    private void backtrack(int index, int sum, int[] numbers, List<Integer> solution) {
        // Condición de éxito
        if (sum == target) {
            solutions.add(new ArrayList<>(solution));
            return;
        }

        // Poda (si la suma excede el objetivo o si el índice alcanza el tamaño del arreglo, se retrocede)
        if (sum > target || index == numbers.length) {
            return;
        }

        // Se incluye el número en el índice actual
        sum += numbers[index];
        solution.add(numbers[index]);
        backtrack(index + 1, sum, numbers, solution); // Recursión en el índice siguiente

        // Se excluye el número en el índice actual
        sum -= numbers[index];
        solution.removeLast();
        backtrack(index + 1, sum, numbers, solution); // Recursión en el índice siguiente
    }

}
