package tp05.e10;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilizando la técnica Backtracking, escribir un algoritmo que dado un conjunto de números enteros,
 * devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro), cuyas sumas sean
 * exactamente cero.
 * Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos que suman cero son:
 * {-7, -1, 8} y {-3, -2, 5}.
 */
public class ZeroSumSubsetsProblem {

    private int[] numbers;
    private boolean[] visited;
    private int subsetSize;

    /**
     * Encuentra todos los subconjuntos de tamaño N cuyas sumas sean exactamente cero.
     *
     * @param subsetSize El tamaño del subconjunto deseado.
     * @param numbers    El conjunto de números enteros de entrada.
     * @return Una lista de listas, donde cada lista interna representa un subconjunto cuya suma es cero.
     */
    public List<List<Integer>> solve(int subsetSize, int[] numbers) {
        if (numbers.length < 2) {
            return new ArrayList<>();
        }

        this.numbers = numbers;
        visited = new boolean[numbers.length];
        this.subsetSize = subsetSize;
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> solution = new ArrayList<>();

        backtrack(0, 0, 0, subset, solution);

        return solution;
    }

    /**
     * Procedimiento recursivo que utiliza la técnica de backtracking para construir subconjuntos de tamaño N.
     *
     * @param start    El índice desde el cual comenzar la búsqueda en el arreglo.
     * @param end      El índice que indice la cantidad de elementos en el subconjunto.
     * @param sum      La suma actual de los elementos en el subconjunto.
     * @param subset   La lista que representa el subconjunto actual en construcción.
     * @param solution La lista principal que contiene todos los subconjuntos encontrados.
     */
    private void backtrack(int start, int end, int sum, List<Integer> subset, List<List<Integer>> solution) {
        // Condición de corte: Se construyó un subconjunto de tamaño N
        if (end == subsetSize) {
            // Condición de éxito: Si la suma de los elementos es 0, se agrega el subconjunto a la solución final
            if (sum == 0) {
                solution.add(new ArrayList<>(subset));
            }
            return;
        }

        // Itera sobre los números restantes a partir del índice 'start' para evitar permutaciones repetidas
        for (int i = start; i < numbers.length; i++) {
            if (!visited[i]) {
                // Se marca el número como visitado y se agrega al subconjunto actual
                visited[i] = true;
                subset.add(numbers[i]);

                // Llamada recursiva al siguiente nivel
                backtrack(i + 1, end + 1, sum + numbers[i], subset, solution);

                // Se deshace el último paso (backtracking)
                visited[i] = false;
                subset.removeLast();
            }
        }
    }

}
