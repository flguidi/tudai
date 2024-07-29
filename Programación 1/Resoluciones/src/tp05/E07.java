package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 07 --- */

/*
Implementar un método que realice un corrimiento a derecha en un arreglo ordenado de tamaño 10 a partir
de una posición.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E07 {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int pos;

        // Carga, ordenamiento e impresión del arreglo original
        cargarArreglo(arr);
        ordenarArregloAsc(arr);
        imprimirArreglo(arr);

        // Entrada de datos solicitados
        System.out.print("Ingrese posición del arreglo (0 a 9) a partir del cual realizar corrimiento a derecha: ");
        pos = leerEntero();

        if (pos >= 0 && pos < MAX) {
            corrimientoADerecha(arr, pos);
            imprimirArreglo(arr);
        } else {
            System.out.println("ERROR");
        }
    }

    // Entrada por teclado de número entero
    public static int leerEntero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = -1;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("ERROR. Intente nuevamente.");
            }
        }

        return num;
    }

    // Carga aleatoria del arreglo entre los valores MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR) + MIN_VALOR;
        }
    }

    // Ordenamiento ascendente por selección
    public static void ordenarArregloAsc(int[] arr) {
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

    // Inserción de elemento y corrimiento a derecha
    public static void corrimientoADerecha(int[] arr, int pos) {
        for (int i = MAX - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    // Impresión de arreglo
    public static void imprimirArreglo(int[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }
}
