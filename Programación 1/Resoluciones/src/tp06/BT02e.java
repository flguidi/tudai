package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Bonus Track 02e --- */

/* 
Dado el siguiente enunciado, corregir el código propuesto:

Escribir un programa que elimine todas las secuencias de tamaño par. No usar estructuras auxiliares.

public class BonusTrack02e {
    final static int MAXFIL = 20, MAXCOL = 20;

    public static void main (String[] args) {
        int[][] matrizA = new int[MAXFIL][MAXCOL];
        int[][] matrizB = new int[MAXFIL][MAXCOL];

        cargarMatriz(matrizA);
        matrizB = eliminarSecuencias(matrizA);
    }
    
    public static void cargarMatriz(int[][] mat) {
        for (int i = 0; i < MAXFIL; i++) {
            cargarArreglo(mat[i]);
        }
    } 

    public static void cargarArreglo(int[] arr) {
        for (int pos = 0 ; pos < MAX; pos++) {
            arr[pos] = pos * 2;
        }

        return arr;
    }

    public static int[][] eliminarSecuencias(int[][] mat) {
        int ini = 0, fin = -1;
        
        for (int i = 0; i < MAXFIL; i++) {
            while (fin < MAXCOL) {
                ini = buscarIni(mat[i], fin + 1);
                
                if (ini < MAXCOL) {
                    fin = buscarFin(mat[i], ini);
                    int tam = fin - ini + 1;
                    
                    if (tam % 2 == 0) {
                        for (; tam > 0 ; tam--) {
                        correrIzq(mat[i], ini);
                        } 
                        
                        fin = ini + 1;
                    } else fin++;
                } else fin = MAXCOL;
            }
        }
    } 
    
    public static int obtenerIni(int[] arr, int ini) {
        while (ini < MAX && arr[ini] == 0)
            ini++;
        return ini;
    } 
    
    public static int obtenerFin(int[] arr, int ini) {
        while (ini < MAX && arr[ini] !=0)
            ini++;
        return ini-1;
    }
}

*/

import java.util.Random;

public class BT02e {
    public static final int MAXFIL = 20, MAXCOL = 20, MIN_VALOR = 1, MAX_VALOR = 9, SEPARADOR = 0;
    public static final double PROBABILIDAD_NUM = 0.8;

    public static void main (String[] args) {
        int[][] matriz = new int[MAXFIL][MAXCOL];

        cargarMatriz(matriz);
        imprimirMatriz(matriz);
        System.out.println("----------------------------------------");
        eliminarSecuenciasTamanioPar(matriz);
        imprimirMatriz(matriz);
    }

    public static void eliminarSecuenciasTamanioPar(int[][] mat) {
        for (int i = 0; i < MAXFIL; i++) {
            int ini = 0, fin = -1;

            while (ini < MAXCOL) {
                ini = obtenerIni(mat[i], fin + 1);
                if (ini < MAXCOL) {
                    fin = obtenerFin(mat[i], ini);
                    int tam = fin - ini + 1;
                    if (tam % 2 == 0) {
                        eliminarSecuencia(mat[i], ini, fin);
                        fin = ini;
                    }
                }
            }
        }
    }

    public static void eliminarSecuencia(int[] arr, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            correrIzquierda(arr, ini);
        }
    }

    public static void correrIzquierda(int[] arr, int pos) {
        for (int i = pos; i < MAXCOL - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }
    
    public static int obtenerIni(int[] arr, int ini) {
        while (ini < MAXCOL && arr[ini] == 0)
            ini++;
        return ini;
    } 
    
    public static int obtenerFin(int[] arr, int ini) {
        while (ini < MAXCOL && arr[ini] !=0)
            ini++;
        return ini-1;
    }

    public static void cargarMatriz(int[][] mat) {
        for (int i = 0; i < MAXFIL; i++) {
            cargarArreglo(mat[i]);
        }
    } 

    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        arr[0] = SEPARADOR;
        arr[MAXCOL - 1] = SEPARADOR;

        for (int pos = 1 ; pos < MAXCOL - 1; pos++) {
            if (PROBABILIDAD_NUM > r.nextDouble()) {
                arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            } else {
                arr[pos] = SEPARADOR;
            }
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < MAXFIL; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println();
        }
    }
}
