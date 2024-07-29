package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Ejercicio tipo parcial 02 --- */

/*
Un dispositivo que lleva un animal bovino en su cuello recolecta datos de un acelerómetro en tres ejes: X Y Z.
Cada toma de datos se representa como una secuencia de valores enteros entre 0 y 1023 para cada eje, las secuencias
están separadas por -1 (valor no válido para esta lógica). El productor quiere conocer cómo se ha comportado su
animal en el transcurso del día y para ello ingresa un patrón de aceleración X Y Z y una cantidad N de repeticiones.
Un patrón que se repite una cierta cantidad de veces consecutivas significa que el animal puede estar pastoreando,
caminando, rumiando, etc. Dado un valor N y el patrón X Y Z en un arreglo inicializado con -1 (de tamaño igual al
arreglo que tiene los datos), hacer un programa en JAVA que compruebe si el patrón se repitió N o más veces y si
es así que elimine del arreglo las secuencias que se siguen repitiendo consecutivamente luego de la cantidad N.

Por ejemplo, si tenemos el siguiente arreglo de datos:
| -1 | 12 | 22 | 44 | -1 | 23 | 34 | 55 | -1 | 23 | 34 | 55 | -1 | 23 | 34 | 55 | -1 | 23 | 34 | 57 | -1 |

El arreglo patrón X Y Z a analizar es X=23, Y=34, Z=55 y el N=2:
| -1 | -1 | -1 | -1 | -1 | -1 | -1 | -1 | 23 | 34 | 55 | -1 | -1 | -1 | -1 | -1 | -1 | -1 | -1 | -1 | -1 |

El arreglo resultante sería:
| -1 | 12 | 22 | 44 | -1 | 23 | 34 | 55 | -1 | 23 | 34 | 55 | -1 | -1 | 23 | 34 | 57 | -1 | -1 | -1 | -1 |
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EjercicioTipoParcial02 {
    public static final int MAX = 21, SEPARADOR = -1, MIN_VALOR = 0, MAX_VALOR = 1023;

    public static void main(String[] args) {
        int[] arr = { -1, 12, 22, 44, -1, 23, 34, 55, -1, 23, 34, 55, -1, 23, 34, 55, -1, 23, 34, 57, -1 };
        int[] arrPatron = { -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, 34, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

        System.out.print("Ingrese un número entero: ");
        int repeticiones = leerEntero();

        System.out.println("Arreglo original:");
        imprimirArreglo(arr);

        eliminarPatrones(arr, arrPatron, repeticiones);

        System.out.println("Arreglo modificado:");
        imprimirArreglo(arr);
    }

    public static void eliminarPatrones(int[] arr, int[] arrPatron, int repeticiones) {
        int iniP, finP, iniS = 0, finS = -1, contador = 0;
        iniP = obtenerInicioSecuencia(arrPatron, 0);
        finP = obtenerFinSecuencia(arrPatron, iniP);

        while (iniS < MAX) {
            iniS = obtenerInicioSecuencia(arr, finS + 1);
            if (iniS < MAX) {
                finS = obtenerFinSecuencia(arr, iniS);
                if (esPatron(arr, iniS, finS, arrPatron, iniP, finP)) {
                    contador++;
                    if (contador > repeticiones) {
                        eliminarSecuencia(arr, iniS, finS);
                        finS = iniS;
                    }
                }
            }
        }
    }

    public static void eliminarSecuencia(int[] arr, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            eliminarElemento(arr, ini);
        }
    }

    public static void eliminarElemento(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static boolean esPatron(int[] arr, int iniS, int finS, int[] arrPatron, int iniP, int finP) {
        if (finS - iniS + 1 == finP - iniP + 1) {
            while (iniS <= finS && arr[iniS] == arrPatron[iniP]) {
                iniS++;
                iniP++;
            }
        }
        return iniS > finS;
    }

    public static int obtenerInicioSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int obtenerFinSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
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
                System.out.println(e);
            }
        }

        return num;
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("| ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}