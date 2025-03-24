package tp02_1;

public class Recursion<T extends Comparable<T>> {

    /**
     * Verifica recursivamente si un arreglo está ordenado ascendentemente.
     * Complejidad: O(n).
     *
     * @param array Arreglo a verificar.
     * @return {@code true} si está ordenado, {@code false} si no lo está.
     */
    public boolean isOrdered(T[] array) {
        if (array == null) {
            return false;
        }

        return isOrderedRec(array, 0);
    }

    private boolean isOrderedRec(T[] array, int index) {
        if (index == array.length - 1) {
            return true;
        }

        if (array[index].compareTo(array[index + 1]) > 0) {
            return false;
        }

        return isOrderedRec(array, index + 1);
    }

    /**
     * Búsqueda binaria recursiva de un elemento en un arreglo ordenado ascendentemente.
     *
     * @param array  Array ordenado en el que se realizará la búsqueda.
     * @param target Elemento que se desea buscar.
     * @return El índice del elemento si se encuentra, -1 en caso contrario.
     */
    public int binarySearch(T[] array, T target) {
        if (array == null || target == null) {
            return -1;
        }

        return binarySearchRec(array, target, 0, array.length - 1);
    }

    private int binarySearchRec(T[] array, T target, int low, int high) {
        // Caso base (índices cruzados; elemento no encontrado)
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2; // Índice medio

        // Se compara el elemento en la posición actual con el buscado
        int comparison = target.compareTo(array[mid]);
        if (comparison < 0) {
            // Si es menor, se busca recursivamente en la mitad izquierda
            return binarySearchRec(array, target, low, mid - 1);
        } else if (comparison > 0) {
            // Si es mayor, se busca recursivamente en la mitad derecha
            return binarySearchRec(array, target, mid + 1, high);
        }

        return mid; // Elemento encontrado
    }

    /**
     * Convierte un número en notación decimal a otro de la base especificada.
     *
     * @param number Número decimal a convertir (debe ser positivo).
     * @param base   Base de conversión (2 <= base <= 10).
     * @return Número binario como una cadena de dígitos.
     */
    public String decimalToBase(int number, int base) {
        if (number < 0 || base < 2 || base > 10) {
            return "";
        }

        return decimalToBaseRec(number, base);
    }

    private String decimalToBaseRec(int number, int base) {
        if (number < base) {
            return Integer.toString(number);
        }
        int remainder = number % base;
        int quotient = number / base;
        return decimalToBaseRec(quotient, base) + remainder;
    }

    /**
     * Función recursiva que devuelve un array con los n primeros números de la secuencia de Fibonacci.
     *
     * @param n Cantidad de términos que se desean obtener.
     * @return Array con los términos de la secuencia de Fibonacci.
     */
    public int[] fibonacci(int n) {
        if (n < 0) {
            return null;
        }

        int[] array = new int[n + 1];
        fibonacciRec(n, array);

        return array;
    }

    private int fibonacciRec(int n, int[] array) {
        // Caso base (si n es igual a 0 o 1, se almacenan en el arreglo en las posiciones correspondientes)
        if (n <= 1) {
            array[n] = n;
            return n;
        }

        // Calcular término Fibonacci y almacenarlo en el array
        int number = fibonacciRec(n - 1, array) + fibonacciRec(n - 2, array);
        array[n] = number;

        return number;
    }

    /**
     * Dado un arreglo, verifica si alguno de sus elementos contiene un valor igual a la posición en la
     * que se encuentra.
     *
     * @param array Array que se verificará.
     * @return {@code true} si se encuentra el elemento, {@code false} si no se encuentra.
     */
    public boolean valueEqualToIndex(int[] array) {
        if (array == null) {
            return false;
        }
        return valueEqualToIndexRec(array, 0);
    }

    private boolean valueEqualToIndexRec(int[] array, int index) {
        if (index >= array.length) {
            return false;
        }

        if (array[index] == index) {
            return true;
        }

        return valueEqualToIndexRec(array, index + 1);
    }

    /**
     * Imprime un arreglo recursivamente.
     * Complejidad: O(n).
     *
     * @param array Arreglo que se imprimirá.
     * @return Cadena de texto que representa el arreglo a imprimir.
     */
    public String printArray(T[] array) {
        if (array == null) {
            return null;
        }

        String output = "[";
        output += printArrayRec(array, 0);
        output += "]";

        return output;
    }

    private String printArrayRec(T[] array, int index) {
        if (index == array.length) {
            return "";
        }

        String output = array[index].toString();
        if (index < array.length - 1) {
            output += ", ";
        }

        return output + printArrayRec(array, index + 1);
    }

}
