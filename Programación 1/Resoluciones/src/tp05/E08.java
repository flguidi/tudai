package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 08 --- */

/*
Implementar un método que realice un corrimiento a izquierda en un arreglo ordenado de tamaño 10 a partir
de una posición.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E08 {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int pos;
        
        // Carga, ordenamiento e impresión de arreglo
        cargarArreglo(arr);
        ordenarArreglo(arr);
        imprimirArreglo(arr);        

        // Entrada de datos solicitados
        System.out.print("Ingrese la posición del arreglo (0 a 9) del elemento a eliminar: ");
        pos = leerEntero();

        if (0 <= pos && pos < MAX) {
            // Eliminación del elemento e impresión del arreglo modificado
            eliminarElemento(arr, pos);
            imprimirArreglo(arr);
        } else {
            System.out.println("ERROR");
        }
    }

    // Entrada de número entero
    public static int leerEntero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = -1;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("ERROR. Intentar nuevamente.");
            }
        }

        return num;
    }

    // Carga aleatoria del arreglo entre los valores MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Ordenamiento ascendente por selección
    public static void ordenarArreglo(int[] arr) {
        int menor, pos;

        for (int i = 0; i < MAX - 1; i++) {
            menor = arr[i];
            pos = i;
            for (int j = i + 1; j < MAX; j++) {
                if (arr[j] < menor) {
                    menor = arr[j];
                    pos = j;
                }
            }
            if (pos != i) {
                int aux = arr[i];
                arr[i] = arr[pos];
                arr[pos] = aux;
            }
        }
    }

    // Eliminación de elemento y corrimiento a izquierda
    public static void eliminarElemento(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // Impresión del arreglo
    public static void imprimirArreglo(int[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }
}
