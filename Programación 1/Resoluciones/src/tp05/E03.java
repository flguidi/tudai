package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 03 --- */

/*
Con el mismo arreglo del ejercicio anterior informe por pantalla cuantos elementos del mismo están por
encima del promedio calculado.
*/

import java.util.Random;

public class E03 {
    public static final int MAX = 10, MIN_VALOR = 1, MAX_VALOR = 10;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int cantMayorAPromedio;
        double promedio;

        cargarArreglo(arr);
        imprimirArreglo(arr);

        promedio = calcularPromedioArreglo(arr);
        System.out.println("El promedio es " + promedio);

        cantMayorAPromedio = calcularCantMayorAPromedio(arr, promedio);
        System.out.println("La cantidad de elementos mayores al promedio es " + cantMayorAPromedio);
    }

    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    public static void imprimirArreglo(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + " ");
        }
        System.out.println();
    }
    
    public static double calcularPromedioArreglo(int[] arr) {
        int suma = 0;
        for (int pos = 0; pos < MAX; pos++) {
            suma += arr[pos];
        }
        return (double) suma / MAX;
    }

    public static int calcularCantMayorAPromedio(int[] arr, double promedio) {
        int contador = 0;
        for (int pos = 0; pos < MAX; pos++) {
            if (arr[pos] > promedio) {
                contador++;
            }
        }
        return contador;
    }
}
