package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Bonus Track 02c --- */

/* Corrección de errores */

import java.util.Random;

public class BT02c {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[] arreglo = new int[MAX];
        int numero = 6;

        cargarArreglo(arreglo);
        mostrarArreglo(arreglo);

        int pos = buscarPosNumero(arreglo, numero);
        if (0 <= pos && pos < MAX) {
            System.out.println("La posicion del número " + numero + " es: " + pos);
        } else {
            System.out.println("El número " + numero + " no se encuentra en el arreglo");
        }
    }

    // Retorna la posición en el arreglo de un número dado (se reemplazó la sentencia for por while)
    public static int buscarPosNumero(int[] arr, int numero) {
        int pos= 0;
        while (pos < MAX && arr[pos] != numero) {
            pos++;
        }
        return pos;
    }

    // Carga aleatoria del arreglo entre los valores MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Impresión del arreglo
    public static void mostrarArreglo(int[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }
}
