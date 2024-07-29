package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 13 --- */

/*
Se tiene una matriz de enteros de tamaño 4x20 de secuencias de números entre 1 y 9 (por cada fila), separadas
por 0. La matriz está precargada, y además cada fila empieza y termina con uno o más separadores 0. Hacer un
programa que dado un número entero ingresado por el usuario, elimine de cada fila las secuencias de tamaño igual
al número ingresado.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E13 {
    public static final int MAXF = 4, MAXC = 20, MIN_VALOR = 1, MAX_VALOR = 9, SEPARADOR = 0;
    public static final double PROBABILIDAD_ELEMENTO = 0.5;
    
    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int num;

        // Se carga la matriz de secuencias y se imprime
        cargarMatrizSecuenciasInt(matriz);
        imprimirMatrizInt(matriz);

        // Se solicita al usuario un número entero
        System.out.print("Ingrese un número entero: ");
        num = leerInt();

        // Para cada fila, se eliminan las secuencias de tamaño igual al número ingresado
        for (int i = 0; i < MAXF; i++) {
            eliminarSecuenciasLongitudN(matriz[i], num);
        }

        // Se imprime la matriz modificada
        System.out.println("--------------------------------------");
        System.out.println("Matriz modificada:");
        imprimirMatrizInt(matriz);
    }

    // Elimina las secuencias de una longitud dada
    public static void eliminarSecuenciasLongitudN(int[] vector, int longitud) {
        int ini = 0, fin = -1;

        while (ini < MAXC) {
            ini = obtenerInicio(vector, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(vector, ini);
                if (fin - ini + 1 == longitud) {
                    eliminarSecuencia(vector, ini, fin);
                    fin = ini;
                }
            }
        }
    }
    
    // Elimina una secuencia dada
    public static void eliminarSecuencia(int[] vector, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            eliminarElemento(vector, ini);
        }
    }

    // Elimina un elemento de un vector, realizando un corrimiento a izquierda
    public static void eliminarElemento(int[] vector, int pos) {
        for (int i = pos; i < MAXC - 1; i++) {
            vector[i] = vector[i + 1];
        }
    }

    // Devuelve la posición de inicio de una secuencia
    public static int obtenerInicio(int[] vector, int pos) {
        while (pos < MAXC && vector[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición de final de una secuencia
    public static int obtenerFin(int[] vector, int pos) {
        while (pos < MAXC && vector[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    // Se obtiene la entrada por teclado de un int
    public static int leerInt() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return num;
    }

    // Carga una matriz con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarMatrizSecuenciasInt(int[][] matriz) {
        Random r = new Random();

        for (int i = 0; i < MAXF; i++) {
            // Se coloca al comienzo y final de cada fila un separador
            matriz[i][0] = SEPARADOR;
            matriz[i][MAXC - 1] = SEPARADOR;

            for (int j = 1; j < MAXC - 1; j++) {
                if (PROBABILIDAD_ELEMENTO > r.nextDouble()) {
                    matriz[i][j] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
                } else {
                    matriz[i][j] = SEPARADOR;
                }
            }
        }
    }

    // Imprime por consola una matriz dada
    public static void imprimirMatrizInt(int[][] matriz) {
        for (int i = 0; i < MAXF; i++) {
            System.out.print("| ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
