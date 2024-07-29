package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 25 --- */

/*
Hacer un programa que dado el arreglo definido y precargado, y un número entero ingresado por el usuario,
copie de forma continua las secuencias de tamaño igual al número ingresado en otro arreglo de iguales
características e inicializado con 0. La copia en este último arreglo deben comenzar desde el principio del mismo.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E25 {
    public static final int MAX = 20;
    public static final double PROBABILIDAD_LETRA = 0.5;

    public static void main(String[] args) {
        int longitud;
        char[] arr1 = new char[MAX];
        char[] arr2 = new char[MAX];

        cargarArreglo(arr1);
        imprimirArreglo(arr1);

        System.out.print("Ingrese tamaño de las secuencias a copiar: ");
        longitud = leerEntero();

        copiarSecuenciasDeLongitudN(arr1, arr2, longitud);
        imprimirArreglo(arr2);
    }

    public static int leerEntero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("Error. Inténtelo nuevamente.");
            }
        }

        return num;
    }

    public static void cargarArreglo(char[] arr) {
        Random r = new Random();
        arr[0] = ' ';
        arr[MAX - 1] = ' ';

        for (int i = 1; i < MAX - 1; i++) {
            if (r.nextDouble() < PROBABILIDAD_LETRA) {
                arr[i] = (char) (r.nextInt(26) + 'a');
            } else {
                arr[i] = ' ';
            }
        }
    }

    public static void copiarSecuenciasDeLongitudN(char[] arr1, char[] arr2, int longitudIngresada) {
        int inicioArr1 = 0, finArr1 = -1, inicioArr2 = 0;
        while (inicioArr1 < MAX) {
            inicioArr1 = obtenerInicioSecuencia(arr1, finArr1 + 1);
            if (inicioArr1 < MAX) {
                finArr1 = obtenerFinSecuencia(arr1, inicioArr1);
                int longitudSecuencia = finArr1 - inicioArr1 + 1; 
                if (longitudSecuencia == longitudIngresada) {
                    copiarSecuencia(arr1, arr2, inicioArr1, inicioArr2, longitudSecuencia);
                    inicioArr2 += longitudSecuencia;
                }
            }
        }
    }

    public static int obtenerInicioSecuencia(char[] arr, int pos) {
        while (pos < MAX && arr[pos] == ' ') {
            pos++;
        }
        return pos;
    }

    public static int obtenerFinSecuencia(char[] arr, int pos) {
        while (pos < MAX && arr[pos] != ' ') {
            pos++;
        }
        return pos - 1;
    }

    public static void copiarSecuencia(char[] arr1, char[] arr2, int inicioArr1, int inicioArr2, int longitud) {
        for (int i = 0; i < longitud; i++) {
            arr2[inicioArr2 + i] = arr1[inicioArr1 + i];
        }
    }

    public static void imprimirArreglo(char[] arr) {
        System.out.print("| ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.print("\n");
    }
}

