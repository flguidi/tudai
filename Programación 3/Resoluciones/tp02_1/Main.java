package tp02_1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Se instancia la clase Recursion, con métodos recursivos
        Recursion<Integer> recursion = new Recursion<>();

        // Se crean dos arreglos e imprimen recursivamente
        Integer[] array1 = {1, 3, 5, 7, 8, 9};
        Integer[] array2 = {1, 4, 9, 7, 2, 3};
        System.out.println("array1: " + recursion.printArray(array1));
        System.out.println("array2: " + recursion.printArray(array2));

        // EJERCICIO 1: Verificar recursivamente si un arreglo está ordenado ascendentemente.
        System.out.println("\nEJERCICIO 1");
        System.out.println("array1 está ordenado: " + recursion.isOrdered(array1));
        System.out.println("array2 está ordenado: " + recursion.isOrdered(array2));

        // EJERCICIO 2: Búsqueda binaria
        System.out.println("\nEJERCICIO 2");
        int n = 9;
        System.out.println("Búsqueda binaria del elemento " + n + " en array1: " + recursion.binarySearch(array1, n));

        // EJERCICIO 3: Conversión de decimal a binario
        System.out.println("\nEJERCICIO 3");
        n = 26;
        int base = 2;
        System.out.println(n + " en base " + base + ": " + recursion.decimalToBase(n, base));

        // EJERCICIO 4: Secuencia de Fibonacci
        System.out.println("\nEJERCICIO 4");
        n = 8;
        int[] fibonacci = recursion.fibonacci(n);
        System.out.print("Fibonacci: " + Arrays.toString(fibonacci));

        // EJERCICIO 5: verificación de valores y posiciones de un arreglo
        System.out.println("\nEJERCICIO 5");
        int[] array3 = {1, 4, 3, 0, 7, 5, 8};
        System.out.println("array3: " + Arrays.toString(array3));
        System.out.println("Elementos con valor igual que su posición: " + recursion.valueEqualToIndex(array3));

        // EJERCICIO 6: ordenamiento por selección (selection sort) y por burbujeo (bubble sort)
        System.out.println("\nEJERCICIO 6");

        Sorter sorter = new Sorter(); // Clase Sorter, con métodos de ordenamiento

        System.out.println("Ordenamiento por selección");
        System.out.print("array3: " + Arrays.toString(array3) + " -> ");
        sorter.selectionSort(array3);
        System.out.println(Arrays.toString(array3));

        System.out.println("Ordenamiento por burbujeo");
        int[] array4 = {5, 2, 4, 3, 7, 8, 6};
        System.out.print("array4: " + Arrays.toString(array4) + " -> ");
        sorter.bubbleSort(array4);
        System.out.println(Arrays.toString(array4));

        // EJERCICIO 7: ordenamiento por mezcla (merge sort) y ordenamiento rápido (quick sort)
        System.out.println("Ordenamiento por mezcla");
        int[] array5 = {2, 5, 3, 7, 9, 4, 0};
        System.out.print("array5: " + Arrays.toString(array5) + " -> ");
        sorter.mergeSort(array5);
        System.out.println(Arrays.toString(array5));

        System.out.println("Ordenamiento rápido");
        int[] array6 = {0, 4, 5, 1, 3, 6, 7};
        System.out.print("array6: " + Arrays.toString(array6) + " -> ");
        sorter.quickSort(array6);
        System.out.println(Arrays.toString(array6));
    }

}
