package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 04 --- */

/*
Hacer un programa que dada una matriz de enteros de tamaño 5x10 que se encuentra precargada, solicite al
usuario un número entero y una posición (fila, columna). Con estos datos tendrá que realizar un corrimiento
a derecha (se pierde el último valor en dicha fila) y colocar el número en la matriz en la posición (fila,
columna) indicada.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E04 {
    public static final int MAXF = 5, MAXC = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int num, fil, col;
        
        cargarMatriz(matriz);
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        System.out.print("\nIngrese el número que desea insertar en la matriz: ");
        num = leerEntero();
        System.out.print("Ingrese número de fila (0 a " + (MAXF - 1) + "): ");
        fil = leerEntero();
        System.out.print("Ingrese número de columna (0 a " + (MAXC - 1) + "): ");
        col = leerEntero();

        if ((0 <= fil && fil < MAXF) && (0 <= col && col < MAXC)) {
            insertarElemento(matriz[fil], col, num);
            System.out.println("\nMatriz modificada:");
            imprimirMatriz(matriz);
        } else {
            System.out.println("Error");
        }
    }

    // Inserta un número dado en una posición del vector dada
    public static void insertarElemento(int[] fil, int pos, int num) {
        for (int i = MAXC - 1; i > pos; i--) {
            fil[i] = fil[i - 1];
        }

        fil[pos] = num;
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
