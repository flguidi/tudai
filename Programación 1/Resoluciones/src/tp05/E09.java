package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 09 --- */

/*
Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra cargado, solicite al usuario
un número entero y lo agregue al principio del arreglo (posición 0). Para ello tendrá que realizar un corrimiento
a derecha (se pierde el último valor del arreglo) y colocar el número en el arreglo en la posición indicada.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E09 {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 9; 
    public static final int POS = 0; // Posición de inserción

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int num;

        cargarArreglo(arr);
        ordenarArregloAsc(arr);
        imprimirArreglo(arr);

        System.out.println("Ingrese un número entero para colocar en arr[" + POS + "]");
        num = leerEntero();

        insertarElementoAlPrincipio(arr, num);
        imprimirArreglo(arr);
    }    

    // Entrada de número entero
    public static int leerEntero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
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
        for (int pos = 0; pos < MAX; pos ++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Ordenamiento ascendente del arreglo por selección
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

    // Inserción de elemento en la posición POS y corrimiento a derecha
    public static void insertarElementoAlPrincipio(int[] arr, int num) {
        for (int i = MAX - 1; i > POS; i--) {
            arr[i] = arr[i - 1];
        }
        arr[POS] = num;
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
