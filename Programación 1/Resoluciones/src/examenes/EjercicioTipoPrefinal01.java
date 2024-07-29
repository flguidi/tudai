package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Ejercicio tipo prefinal 01 --- */

/* 
El proyecto SETI de la NASA quiere analizar una serie de señales recibidas por su radiotelescopio. El
radiotelescopio realiza lecturas en 18 canales en la frecuencia del hidrógeno neutro. Dichas señales son
almacenadas en una matriz en donde cada fila representa una lectura realizada por el radiotelescopio y cada
columna representa la intensidad captada para los 18 canales de rastreo. Cada intensidad se representa por
una serie de caracteres alfanuméricos: si el valor es un 0, se representa mediante un espacio en blanco;
los valores entre el 1 y el 9 son representados por los caracteres del '1' al '9'; y los valores del 10 al
35 son representados con las letras mayúsculas que van de la 'A' a la 'Z' respectivamente. Por lo tanto, en
cada fila se forman secuencias de valores separadas por espacios, en donde cada secuencia representa las
lecturas en canales de rastreo consecutivos.

Dado una matriz de NxM, donde N es la cantidad de lecturas realizadas y M la cantidad de canales analizados
más 2 (cada fila comienza y termina con un espacio), se pide: determinar la cantidad de señales de posible
origen extraterrestre en la matriz. Una señal es de posible origen extraterrestre si en P lecturas consecutivas
(filas) existen al menos K intensidades superiores a un determinado valor alfanumérico L en una de sus secuencias
(canales de rastreo con lecturas consecutivas distintas de 0).

Para el siguiente ejemplo donde N = 5 y M = 20 (18 canales), K = 2, L = 'F' y P = 2 existe UNA señal de posible
origen extraterrestre en las lecturas 0 y 1:

|   | 1 | 2 | G | H |   | 2 | A | 3 |   | 3 | R | B | J |   | 6 | 5 | K |   |   |
|   |   | 2 | 1 | 4 | 5 |   | R | P |   | D | 3 |   | 7 | M | N | W |   |   |   |
|   | 4 | G | 8 |   | 3 | 5 | 7 | 1 |   |   | 2 | X |   | D | 4 | 1 |   |   |   |
|   |   |   | 5 | T | T | M |   | A | P | 1 | 1 |   | 2 | 1 | 3 |   | 1 | 3 |   |
|   | 6 | 6 | 4 |   | 5 | 4 |   |   | A | 2 | 1 | 2 |   | G | 4 | 2 | 1 | 8 |   |

Eso es así porque, en la fila 0, la secuencia 12GH y la secuencia 3RBJ poseen al menos dos intensidades superiores
a 'F', además, de forma consecutiva, en la fila 1, la secuencia RP y la secuencia 7MNW también lo cumplen. Nótese
que la fila 4 cumple el criterio de que al menos posee una secuencia con más de dos intensidades superiores a ‘F’
pero no la fila que sigue (fila 5).

El ejemplo es meramente ilustrativo y para que sea más fácil la interpretación del enunciado. El programa realizado
debe ser flexible para procesar cualquier matriz y para cualquier valor que pueda tomar K, L y P.
*/

public class EjercicioTipoPrefinal01 {
    public static final int N = 5, M = 20, P = 2, K = 2;
    public static final char L = 'F', SEPARADOR = ' ';

    public static void main(String[] args) {
        char[][] matriz = {
                { ' ', '1', '2', 'G', 'H', ' ', '2', 'A', '3', ' ', '3', 'R', 'B', 'J', ' ', '6', '5', 'K', ' ', ' ' },
                { ' ', ' ', '2', '1', '4', '5', ' ', 'R', 'P', ' ', 'D', '3', ' ', '7', 'M', 'N', 'W', ' ', ' ', ' ' },
                { ' ', '4', 'G', '8', ' ', '3', '5', '7', '1', ' ', ' ', '2', 'X', ' ', 'D', '4', '1', ' ', ' ', ' ' },
                { ' ', ' ', ' ', '5', 'T', 'T', 'M', ' ', 'A', 'P', '1', '1', ' ', '2', '1', '3', ' ', '1', '3', ' ' },
                { ' ', '6', '6', '4', ' ', '5', '4', ' ', ' ', 'A', '2', '1', '2', ' ', 'G', '4', '2', '1', '8', ' ' },
        };

        // Se imprime la matriz
        System.out.println("Matriz:");
        imprimirMatriz(matriz, M);

        // Se calcula y se muestra la cantidad de señales de origen extraterrestre
        int cantSenialesExtraterrestres = buscarSenialesExtraterrestres(matriz);
        System.out.println("Cantidad de señales de origen extraterrestre: " + cantSenialesExtraterrestres);
    }

    // Devuelve la cantidad de señales extraterrestres encontradas en una matriz
    public static int buscarSenialesExtraterrestres(char[][] matriz) {
        int cantSenialesExtraterrestres = 0, lecturasIntensasConsecutivas = 0;

        for (int lectura = 0; lectura < N; lectura++) {
            if (esLecturaIntensa(matriz[lectura])) {
                lecturasIntensasConsecutivas++;
            } else {
                lecturasIntensasConsecutivas = 0;
            }

            if (lecturasIntensasConsecutivas == P) {
                cantSenialesExtraterrestres++;
                lecturasIntensasConsecutivas = 0;
            }
        }

        return cantSenialesExtraterrestres;
    }

    // Verifica si una lectura posee al menos K intensidades superiores que L
    public static boolean esLecturaIntensa(char[] lectura) {
        int ini = 0, fin = -1;
        boolean esIntensa = false;
        while (ini < M && !esIntensa) {
            ini = obtenerInicioSecuencia(lectura, fin + 1);
            if (ini < M) {
                fin = obtenerFinSecuencia(lectura, ini);
                esIntensa = esSecuenciaIntensa(lectura, ini, fin);
            }
        }
        return esIntensa;
    }

    // Verifica si una secuencia posee al menos K intensidades superiores que L
    public static boolean esSecuenciaIntensa(char[] lectura, int ini, int fin) {
        int cantIntensidadesSuperiores = 0;
        while (ini <= fin && cantIntensidadesSuperiores < K) {
            if (lectura[ini] >= L) {
                cantIntensidadesSuperiores++;
            }
            ini++;
        }
        return cantIntensidadesSuperiores == K;
    }

    // Devuelve la posición inicial de una secuencia
    public static int obtenerInicioSecuencia(char[] arr, int pos) {
        while (pos < M && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición final de una secuencia
    public static int obtenerFinSecuencia(char[] arr, int pos) {
        while (pos < M && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }   

    // Imprime por consola una matriz dada
    public static void imprimirMatriz(char[][] matriz, int cantColumnas) {
        for (int fila = 0; fila < N; fila++) {
            imprimirArreglo(matriz[fila], cantColumnas);
        }
    }

    // Imprime por consola un arreglo dado
    public static void imprimirArreglo(char[] arr, int cantElementos) {
        System.out.print("| ");
        for (int i = 0; i < cantElementos; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}
