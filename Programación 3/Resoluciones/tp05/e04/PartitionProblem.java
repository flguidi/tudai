package tp05.e04;

import java.util.ArrayList;
import java.util.List;

/**
 * Partición de conjunto:
 * Dado un conjunto de n enteros se desea encontrar, si existe, una partición en dos subconjuntos disjuntos,
 * tal que la suma de sus elementos sea la misma.
 */
public class PartitionProblem {

    /**
     * Encuentra dos particiones de un conjunto de enteros tal que la suma de los elementos
     * de ambos subconjuntos sea igual.
     *
     * @param numbers El arreglo de números enteros a particionar.
     * @return Una lista de listas que contiene dos subconjuntos si existe una partición; de lo contrario, una lista vacía.
     */
    public List<List<Integer>> findPartitions(int[] numbers) {
        int totalSum = 0;
        for (int num : numbers) {
            totalSum += num;
        }

        // Si la suma total de los elementos es impar, no hay subconjuntos cuya suma sea igual
        if (totalSum % 2 != 0) {
            return new ArrayList<>();
        }

        // El valor objetivo es la mitad de la suma total
        int target = totalSum / 2;

        List<List<Integer>> partitions = new ArrayList<>();
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();
        boolean[] used = new boolean[numbers.length];

        // Se verifica mediante backtracking si se puede particionar el conjunto
        if (backtrack(0, target, used, subset1, numbers)) {
            // Si se pueden particionar, los elementos no usados forman el segundo subconjunto
            for (int i = 0; i < numbers.length; i++) {
                if (!used[i]) {
                    subset2.add(numbers[i]);
                }
            }
            partitions.add(subset1);
            partitions.add(subset2);
            return partitions;
        }

        return new ArrayList<>();
    }

    /**
     * Función auxiliar que intenta construir un subconjunto con suma igual al objetivo utilizando backtracking.
     *
     * @param index     El índice actual en el arreglo de números.
     * @param remaining El valor restante que se necesita para completar el subconjunto.
     * @param used      Un arreglo booleano que indica si un elemento ha sido utilizado.
     * @param subset1   La lista que representa el primer subconjunto en construcción.
     * @param numbers   El arreglo de números enteros.
     * @return {@code true} si se puede construir el subconjunto; {@code false} en caso contrario.
     */
    private boolean backtrack(int index, int remaining, boolean[] used, List<Integer> subset1, int[] numbers) {
        // Si el resto es 0, se encontraron dos subconjuntos cuya suma es igual al objetivo
        if (remaining == 0) {
            return true;
        }

        // Si el resto es negativo o si el índice supera el tamaño del arreglo, no se encontraron los subconjuntos
        if (remaining < 0 || index >= numbers.length) {
            return false;
        }

        // Se incluye el elemento actual en el subconjunto
        subset1.add(numbers[index]);
        remaining -= numbers[index];
        used[index] = true;
        if (backtrack(index + 1, remaining, used, subset1, numbers)) {
            return true;
        }

        // Se excluye el elemento actual en el subconjunto
        subset1.removeLast();
        remaining += numbers[index];
        used[index] = false;
        return backtrack(index + 1, remaining, used, subset1, numbers);
    }

}
