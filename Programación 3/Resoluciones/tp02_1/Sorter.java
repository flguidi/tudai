package tp02_1;

public class Sorter {

    /**
     * Algoritmo de ordenamiento por selección (Selection Sort).
     * Complejidad: O(n^2).
     *
     * @param array Array que se ordenará.
     */
    public void selectionSort(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, i, min);
            }
        }
    }

    /**
     * Algoritmo de ordenamiento por burbujeo (Bubble Sort).
     * Complejidad: O(n^2).
     *
     * @param array Array que se ordenará.
     */
    public void bubbleSort(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * Algoritmo de ordenamiento por mezcla (Merge Sort).
     * Complejidad: O(n log n).
     *
     * @param array Array que se ordenará.
     */
    public void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        mergeSortRec(array, 0, array.length - 1);
    }

    private void mergeSortRec(int[] array, int low, int high) {
        // Caso base (arrays de un solo elemento ya están ordenados)
        if (low >= high) {
            return;
        }

        // Se calcula el punto medio y se divide recursivamente cada mitad
        int mid = (low + high) / 2;
        mergeSortRec(array, low, mid);          // Mitad izquierda
        mergeSortRec(array, mid + 1, high); // Mitad derecha

        // Se combinan mitades ordenadas
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high) {
        // Arreglos temporales para cada mitad
        int[] L = new int[mid - low + 1];   // Arreglo para mitad izquierda
        int[] R = new int[high - mid];      // Arreglo para mitad derecha

        // Se copian los datos a los arreglos temporales
        for (int i = 0; i < L.length; i++) {
            L[i] = array[low + i];
        }
        for (int j = 0; j < R.length; j++) {
            R[j] = array[mid + 1 + j];
        }

        // Se combinan los arreglos temporales
        int i = 0;      // índice izquierdo
        int j = 0;      // índice derecho
        int k = low;    // índice general
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Se copian los elementos restantes de L[], si hay alguno
        while (i < L.length) {
            array[k] = L[i];
            i++;
            k++;
        }
    }

    /**
     * Algoritmo de ordenamiento rápido (Quicksort).
     * Complejidad temporal: O(n log n).
     *
     * @param array Array que se ordenará.
     */
    public void quickSort(int[] array) {
        if (array == null) {
            return;
        }
        quickSortRec(array, 0, array.length - 1);
    }

    private void quickSortRec(int[] array, int low, int high) {
        // Caso base (arrays de un solo elemento ya están ordenados)
        if (low >= high) {
            return;
        }

        // Se elije un pivot (en este caso, el último elemento)
        int pivot = array[high];

        // Se particiona el array y se obtiene el índice del pivot ya ordenado
        int sortedPivotIndex = partition(array, low, high, pivot);

        // Llamadas recursivas para ordenar los sub-arrays izquierdo y derecho del pivot (ubicado en lp)
        quickSortRec(array, low, sortedPivotIndex - 1);
        quickSortRec(array, sortedPivotIndex + 1, high);
    }

    private int partition(int[] array, int low, int high, int pivot) {
        // Punteros que intercambiarán valores
        int leftPointer = low;
        int rightPointer = high;

        while (leftPointer < rightPointer) {
            // Incremento de puntero izquierdo
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            // Decremento de puntero derecho
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // Intercambio de valores en ambos punteros
            swap(array, leftPointer, rightPointer);
        }

        // Intercambio del pivot (high) con el elemento en la posición correcta (leftPointer)
        swap(array, leftPointer, high);

        return leftPointer;
    }

    /**
     * Intercambia dos elementos de lugar en un array dado.
     *
     * @param array Array donde se realiza el intercambio.
     * @param i     Índice del primer elemento.
     * @param j     Índice del segundo elemento.
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
