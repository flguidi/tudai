package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Parcial - Ejercicio 01 --- */

/* 
Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una plataforma tecnológica con
recursos limitados. Cada imagen (representada por una matriz de NxM) está compuesta por píxeles con valores
entre 0 y 255. Se desea implementar un algoritmo de compresión que comprima aquellas porciones de la imagen
distintas del color negro (0 en la escala de valores del pixel). Se debe implementar la solución para un arreglo
(luego dicha solución se reutilizará en un futuro para cada fila de la matriz). Para ello, se pide realizar un
programa en JAVA que, dado un arreglo de tamaño M, para cada secuencia delimitada por uno o mas pixeles de color
negro (valor 0) con más de X repeticiones de un valor de píxel (todos los elementos de la secuencia deben ser
iguales), comprima la secuencia poniendo en la primera posición el valor negado de la cantidad de ocurrencias y a
continuación el valor del pixel que se repite. El arreglo empieza y termina con un separador 0 (color negro).
Implementar usando las buenas prácticas de programación estructurada vistas en la cátedra.

Ejemplo:
Arreglo que tiene una fila de la imagen:
| 0 | 67 |67 | 67 | 67 | 67 | 67 | 67 | 67 | 0 | 14 | 0 | 33 | 33 | 33 | 33 | 0 | 5 | 98 | 0 |

El arreglo quedaría de la siguiente forma, para un X = 3:
| 0 | -8 | 67 | 0 | 14 | 0 | -4 | 33 | 0 | 5 | 98 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ParcialEjercicio01 {
    public static final int MAX = 20, SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arr = { 0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0 };

        // Se solicita al usuario el número de repeticiones a partir del cual realizar la compresión
        System.out.print("Ingrese un número entero: ");
        int repeticiones = leerEntero();

        // Se imprime el arreglo original
        System.out.println("Arreglo original:");
        imprimirArreglo(arr);

        // Se comprimen las secuencias del arreglo
        comprimirSecuenciasArreglo(arr, repeticiones);

        // Se imprime el arreglo modificado
        System.out.println("Arreglo modificado:");
        imprimirArreglo(arr);
    }

    // Comprime las secuencias de un arreglo a partir de un número de repeticiones dado
    public static void comprimirSecuenciasArreglo(int[] arr, int repeticiones) {
        int ini = 0, fin = -1, longitudSecuencia;
        while (ini < MAX) {
            ini = obtenerInicio(arr, fin + 1);
            if (ini < MAX) {
                fin = obtenerFin(arr, ini);
                longitudSecuencia = fin - ini + 1;
                if (longitudSecuencia > repeticiones && sePuedeComprimir(arr, ini, fin)) {
                    comprimirSecuencia(arr, ini, fin);
                    fin = ini + 1; // Se actualiza el índice final de la secuencia comprimida
                }
            }
        }
    }

    // Comprime una secuencia dada
    public static void comprimirSecuencia(int[] arr, int ini, int fin) {
        int longitudSecuencia = fin - ini + 1;
        arr[ini] = longitudSecuencia * -1;
        for (int i = ini + 2; i <= fin; i++) {
            eliminarElemento(arr, ini + 2);
        }
    }

    // Elimina el elemento en una posición del arreglo dada
    public static void eliminarElemento(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // Verifica si una secuencia se puede comprimir
    public static boolean sePuedeComprimir(int[] arr, int ini, int fin) {
        while (ini < fin && arr[ini] == arr[ini + 1]) {
            ini++;
        }
        return ini == fin;
    }

    // Devuelve la posición inicial de una secuencia
    public static int obtenerInicio(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición final de una secuencia
    public static int obtenerFin(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != SEPARADOR) {
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

    // Imprime por consola un arreglo dado
    public static void imprimirArreglo(int[] arr) {
        System.out.print("| ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}
