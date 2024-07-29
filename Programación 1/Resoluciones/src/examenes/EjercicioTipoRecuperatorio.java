package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Ejercicio tipo recuperatorio --- */

/*
Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una plataforma tecnológica con
recursos limitados. Cada imagen (representada por una matriz de NxM) está compuesta por píxeles con valores
entre 0 y 255. Se tiene implementado un algoritmo de compresión que comprime aquellas porciones de la imagen
distintas del color negro (0 en la escala de valores del pixel). Dicho algoritmo procede de la siguiente manera:
por cada una de las filas de la matriz, toma cada secuencia delimitada por uno o mas pixeles de color negro
(valor 0) con más de X repeticiones de un valor de píxel (para ser comprimida todos los elementos de la secuencia
deben ser iguales), comprime la secuencia poniendo en la primera posición el valor negado de la cantidad de
ocurrencias y a continuación el valor del pixel que se repite. Cada fila de la matriz empieza y termina con uno o
más pixeles negros.

Se pide implementar el algoritmo de descompresión que restablezca la matriz original. Asumir que cada fila posee
suficientes lugares como para realizar la descompresión.

Ejemplo de matriz comprimida con X = 3:
| 0 | -8 |67  |0   | 14 | 0  | -4 | 33 | 0  | 5  | 98 | 0  | 0  | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| 0 | 0  | 25 | 25 | 0  | -5 |  3 | 0  | 25 | 44 | 44 | 0  | -4 | 1 | 0 | 0 | 0 | 0 | 0 | 0 |
| 0 | 44 | 44 | 44 | 0  | -7 | 15 | 0  | -4 | 9  | 0  | 12 | 0  | 0 | 0 | 0 | 0 | 0 | 0 | 0 |

La matriz resultante quedaría de la siguiente forma:
| 0 | 67 | 67 | 67 | 67 | 67 | 67 | 67 | 67 | 0  | 14 | 0  | 33 | 33 | 33 | 33 | 0 | 5 | 98 | 0 |
| 0 | 0  | 25 | 25 | 0  | 3  | 3  | 3  | 3  | 3  | 0  | 25 | 44 | 44 | 0  | 1  | 1 | 1 | 1  | 0 |
| 0 | 44 | 44 | 44 | 0  | 15 | 15 | 15 | 15 | 15 | 15 | 15 | 0  | 9  | 9  | 9  | 9 | 0 | 12 | 0 |
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EjercicioTipoRecuperatorio {
    public static final int MAXF = 3, MAXC = 20, SEPARADOR = 0;

    public static void main(String[] args) {
        int[][] matriz = {
                { 0, -8, 67, 0, 14, 0, -4, 33, 0, 5, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 25, 25, 0, -5, 3, 0, 25, 44, 44, 0, -4, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 44, 44, 44, 0, -7, 15, 0, -4, 9, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        // Impresión de matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        // Entrada de datos
        System.out.print("Ingrese un número entero: ");
        int repeticiones = leerEntero();

        // Procesamiento
        descomprimirMatrizSecuencias(matriz, repeticiones);

        // Impresión de matriz modificada
        System.out.println("Matriz modificada:");
        imprimirMatriz(matriz);        
    }

    // Comprime las secuencias numéricas de una matriz con un número de repeticiones dado
    public static void descomprimirMatrizSecuencias(int[][] matriz, int repeticiones) {
        for (int fila = 0; fila < MAXF; fila++) {
            descomprimirArregloSecuencias(matriz[fila], repeticiones);
        }
    }

    // Comprime las secuencias numéricas de un arreglo con un número de repeticiones dado
    public static void descomprimirArregloSecuencias(int[] arr, int repeticiones) {
        int ini = 0, fin = -1;
        while (ini < MAXC) {
            ini = obtenerInicioSecuencia(arr, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFinSecuencia(arr, ini);
                if (sePuedeDescomprimir(arr, ini, fin, repeticiones)) {
                    int cantElementos = arr[ini] * -1;
                    descomprimirSecuencia(arr, ini);
                    fin = ini + cantElementos - 1;
                }
            }
        }
    }

    // Descomprime una secuencia dada
    public static void descomprimirSecuencia(int[] arr, int pos) {
        int cantElementos = arr[pos] * -1;
        int elemento = arr[pos + 1];
        for (int i = pos; i < (cantElementos - 2) + pos; i++) {
            correrADerecha(arr, pos);
        }
        for (int i = pos; i < cantElementos + pos; i++) {
            arr[i] = elemento;
        }
    }

    // Realiza un corrimiento a derecha a partir de una posición dada
    public static void correrADerecha(int[] arr, int pos) {
        for (int i = MAXC - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    // Verifica si una secuencia dada se puede descomprimir
    public static boolean sePuedeDescomprimir(int[] arr, int ini, int fin, int repeticiones) {
        int longitudSecuencia = fin - ini + 1;
        int pos = MAXC - 1;
        
        // Se verifica la longitud de la secuencia y se compara con el número de repeticiones
        if (longitudSecuencia == 2 && arr[ini] * -1 > repeticiones) {
            // Se verifica si hay suficiente espacio para descomprimir la secuencia
            while (pos >= 0 && arr[pos] == SEPARADOR) {
                pos--;
            }
            return pos < (MAXC - 1 - (arr[ini] * -1 - 2));
        }
        return false;
    }

    // Devuelve la posición inicial de una secuencia
    public static int obtenerInicioSecuencia(int[] arr, int pos) {
        while (pos < MAXC && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición final de una secuencia a partir de una posición inicial
    public static int obtenerFinSecuencia(int[] arr, int pos) {
        while (pos < MAXC && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    // Lee la entrada por teclado de un dato de tipo int
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

    // Imprime por consola una matriz dada
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < MAXF; i++) {
            System.out.print("| ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
