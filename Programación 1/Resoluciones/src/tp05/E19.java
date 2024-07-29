package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 19 --- */

/*
Hacer un programa que dado un número N ingresado por el usuario, elimine las secuencias de tamaño N
de números distintos de cero.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E19 {
    public static final int MAX = 20, MIN_VALOR = 1, MAX_VALOR = 9;
    public static final double probabilidadNumero = 0.7;

    public static void main(String[] args) {
        int[] vector = new int[MAX];
        int longitud = 0;

        // Carga e impresión de vector original
        cargarVectorSecuenciasInt(vector);
        imprimirVector(vector);

        // Entrada de datos
        System.out.print("Ingrese la longitud de la/s secuencia/s que desea eliminar: ");
        longitud = leerEntero();
    
        // Procesamiento
        eliminarSecuenciasDeLongitudN(vector, longitud);

        // Impresión de vector modificado
        imprimirVector(vector);
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
                System.out.println("Error. Intentar nuevamente.");
            }
        }

        return num;
    }

    // Carga de vector con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarVectorSecuenciasInt(int[] vector) {
        Random r = new Random();
        vector[0] = 0;
        vector[MAX - 1] = 0;

        for (int i = 1; i < MAX - 1; i++) {
            if (probabilidadNumero > r.nextDouble()) {
                vector[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            } else {
                vector[i] = 0;
            }
        }
    }

    // Eliminación de secuencia/s de de longitud N (dada por el usuario)
    public static void eliminarSecuenciasDeLongitudN(int[] vector, int longitud) {
        int inicio = 0, fin = -1, cantElementos;
    
        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(vector, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(vector, inicio);
                cantElementos = fin - inicio + 1;
                if (cantElementos == longitud) {
                    eliminarSecuencia(vector, inicio, cantElementos);
                    fin = inicio;
                }
            }
        }
    }

    // Obtención de inicio de secuencia
    public static int obtenerInicioSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] == 0) {
            pos++;
        }
        return pos;
    }

    // Obtención de fin de secuencia
    public static int obtenerFinSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    // Eliminación de secuencia y corrimiento a izquierda
    public static void eliminarSecuencia(int[] vector, int inicio, int cantElementos) {
        for (int i = 0; i < cantElementos; i++) {
            eliminarElemento(vector, inicio);
        }
    }

    // Eliminación de elemento de vector y corrimiento a izquierda
    public static void eliminarElemento(int[] vector, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            vector[i] = vector[i + 1];
        }
    }

    // Impresión de vector
    public static void imprimirVector(int[] vector) {
        System.out.print("|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(vector[i] + "|");
        }
        System.out.print("\n");
    }
}
