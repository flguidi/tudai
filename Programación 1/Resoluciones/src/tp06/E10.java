package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 10 --- */

/*
Se tiene una matriz de enteros de tamaño 4x20 de secuencias de números entre 1 y 9 (por cada fila), separadas
por 0. La matriz está precargada, y además cada fila empieza y termina con uno o más separadores 0. Hacer un
programa que permita obtener a través de métodos la posición de inicio y la posición de fin de la secuencia
ubicada a partir de una posición entera y una fila, ambas ingresadas por el usuario. Finalmente, si existen
imprima por pantalla ambas posiciones obtenidas.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E10 {
    public static final int MAXF = 4, MAXC = 20, MIN_VALOR = 1, MAX_VALOR = 9, SEPARADOR = 0;
    public static final double PROBABILIDAD_ELEMENTO = 0.8;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int fila, pos;

        // Se carga la matriz con secuencias y se imprime
        cargarMatrizSecuenciasInt(matriz);
        imprimirMatrizInt(matriz);

        // Se solicia al usuario el número de fila
        System.out.print("Ingrese número de fila: ");
        fila = leerInt();

        // Se verifica si el número de fila es correcto
        if (0 <= fila && fila < MAXF) {
            // Se solicita al usuario la posición de la fila indicada
            System.out.print("Ingrese posición: ");
            pos = leerInt();

            if (0 <= pos && pos < MAXC) {
                if (matriz[fila][pos] == SEPARADOR) {
                    System.out.println("Separador");
                } else {
                    int inicio = obtenerInicioSecuenciaBuscada(matriz[fila], pos);
                    int fin = obtenerFin(matriz[fila], inicio);
                    
                    System.out.println("Inicio: " + inicio);
                    System.out.println("Fin: " + fin);
                }
            } else {
                System.out.println("La posición " + pos + " excede los límites de la fila");
            }
        } else {
            System.out.println("Fila fuera de los límites de la matriz.");
        }
    }

    // Devuelve el inicio de una secuencia específica a partir de una posición dada
    public static int obtenerInicioSecuenciaBuscada(int[] vector, int pos) {
        int inicio = 0, fin = -1, inicioBuscado = 0;
        
        while (inicio < MAXC) {
            inicio = obtenerInicio(vector, fin + 1);
            if (inicio < MAXC) {
                fin = obtenerFin(vector, inicio);
                if (inicio <= pos && pos <= fin) {
                    inicioBuscado = inicio;
                }
            }
        }

        return inicioBuscado;
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
