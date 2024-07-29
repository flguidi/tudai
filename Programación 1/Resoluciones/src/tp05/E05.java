package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 05 --- */

/*
Hacer un programa que dado un arreglo de caracteres de tamaño 10 que se encuentra cargado, invierta el orden
del contenido. Este intercambio no se debe realizar de manera explícita, hay que hacer un método que incluya
una iteración de intercambio.
*/

import java.util.Random;

public class E05 {
    public static final int MAX = 10, MIN_VALOR = 1, MAX_VALOR = 10;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int[] arrInvertido;

        // Carga de arreglo aleatoria
        cargarArreglo(arr);

        // Almacenamiento de la copia del arreglo invertido en 'arrInvertido'
        arrInvertido = invertirArreglo(arr);
        
        // Impresión de arreglos
        System.out.println("Arreglo original:");
        imprimirArreglo(arr);
        System.out.println("Arreglo invertido:");
        imprimirArreglo(arrInvertido);
    }

    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR) + MIN_VALOR;
        }
    }

    public static int[] invertirArreglo(int[] arr) {
        int[] arrInvertido = new int[MAX];
        for (int pos = 0; pos < MAX; pos++) {
            arrInvertido[MAX - pos - 1] = arr[pos];
        }
        return arrInvertido;        
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }
}
