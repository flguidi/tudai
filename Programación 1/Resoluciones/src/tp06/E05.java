package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 05 --- */

/*
Hacer un programa que dada una matriz de enteros de tamaño 5x10 que se encuentra precargada, solicite al
usuario un número entero y elimine la primera ocurrencia de número en la matriz (un número igual) si existe.
Para ello tendrá que buscar la posición y si está, realizar un corrimiento a izquierda y no continuar buscando.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E05 {
    public static final int MAXF = 5, MAXC = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int num;
        
        cargarMatriz(matriz);
        
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);
        
        System.out.print("Ingrese el número entero que desea eliminar: ");
        num = leerEntero();
        
        buscarYEliminarElemento(matriz, num);
 
        System.out.println("Matriz modificada:");
        imprimirMatriz(matriz);
    }

    // Busca un elemento dado y elimina de la matriz su primera ocurrencia
    public static void buscarYEliminarElemento(int[][] matriz, int num) {
        int fil = 0, col = 0, filNum = 0, colNum = 0;
        boolean seEncontro = false;

        while (fil < MAXF && !seEncontro) {
            while (col < MAXC && !seEncontro) {
                if (matriz[fil][col] == num) {
                    seEncontro = true;
                    filNum = fil;
                    colNum = col;
                }
                col++;
            }
            col = 0;
            fil++;
        }

        if (fil != MAXF) {
            eliminarElemento(matriz[filNum], colNum);
        } else {
            System.out.println("No se encontró el número " + num);
        }
    }

    // Elimina el elemento en una posición dada, realizando un corrimiento a izquierda
    public static void eliminarElemento(int[] vector, int pos) {
        for (int i = pos; i < MAXC - 1; i++) {
            vector[i] = vector[i + 1];
        }
    }

    // Lectura de número entero por teclado
    public static int leerEntero() {
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

    // Carga aleatoria de matriz con valores entre MIN_VALOR y MAX_VALOR
    public static void cargarMatriz(int[][] matriz) {
        Random r = new Random();
        for (int i = 0; i < MAXF; i++) {
            for (int j = 0; j < MAXC; j++) {
                matriz[i][j] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            }
        }
    }

    // Impresión por consola de matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < MAXF; i++) {
            System.out.print("| ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.print("\n");
        }
    }
}
