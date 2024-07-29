package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 01 --- */

/*
Cargar un arreglo de tamaño 15, pidiendo el ingreso por teclado de valores entre 1 y 12. Luego mostrar cómo
quedó cargado.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E01 {
    public static final int MAX = 15;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        cargarArreglo(arr);
        System.out.println("Arreglo:");
        imprimirArreglo(arr);
    }

    public static void cargarArreglo(int[] arr) {
        System.out.println("Ingrese números enteros entre 1 y 12");
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + i + "]: ");
            arr[i] = leerNumero();
        }
    }

    public static int leerNumero() {
        int num = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        boolean esValido = false;
        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                if (1 <= num && num <= 12) {
                    esValido = true;
                } else {
                    System.out.print("Número incorrecto. Intentar nuevamente: ");
                }
            } catch (Exception e) {
                System.out.println("ERROR: no se ingresó un número entero.");
            }
        }
        
        return num;
    }

    public static void imprimirArreglo(int[] arr) {
        for (int i = 0; i < MAX; i++)
            System.out.print(arr[i] + " ");
    }
}
