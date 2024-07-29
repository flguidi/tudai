package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 12 --- */

/*
Suponer a partir de lo resuelto en el ejercicio anterior (11) que el elemento a eliminar coincide con el
último que hay en el arreglo. ¿Qué ocurre en este caso? ¿Cómo daría una solución al problema?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E12 {
    public static final int MAX = 10, MIN_VALOR = 1, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[] vector = new int[MAX];
        int num;

        // Carga e impresión de vector original
        cargarVector(vector);

        // Impresión de vector original
        System.out.println("Vector original:");
        imprimirVector(vector);

        // Entrada de datos
        System.out.print("Ingrese el número que desea eliminar del vector: ");
        num = leerEntero();

        // Eliminación de todas las ocurrencias del número ingresado
        eliminacionOcurrencias(vector, num);

        // Impresión de vector modificado
        System.out.println("Vector modificado:");
        imprimirVector(vector);
    }

    // Lectura de número entero
    public static int leerEntero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("Error. Intentar nuevamente.");
            }
        }

        return num;
    }

    // Carga aleatoria de vector con valores entre MIN_VALOR y MAX_VALOR
    public static void cargarVector(int[] vector) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            vector[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Eliminación de todas las ocurrencias del número ingresado por el usuario
    public static void eliminacionOcurrencias(int[] vector, int num) {
        int pos = 0;
        while (pos < MAX) {
            pos = buscarOcurrencia(vector, pos, num);
            eliminarOcurrencia(vector, pos);
        }
    }

    // Búsqueda de primera ocurrencia
    public static int buscarOcurrencia(int[] vector, int pos, int num) {
        while (pos < MAX && vector[pos] != num) {
            pos++;
        }
        return pos;
    }

    // Eliminación de elemento y corrimiento a izquierda
    public static void eliminarOcurrencia(int[] vector, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            vector[i] = vector[i + 1];
        }
        vector[MAX-1] = 0;
    }

    // Impresión de vector
    public static void imprimirVector(int[] vector) {
        System.out.print("|  ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(vector[i] + "  |  ");
        }
        System.out.println();
    }
}
