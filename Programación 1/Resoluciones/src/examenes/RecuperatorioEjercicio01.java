package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Recuperatorio - Ejercicio 01 --- */

/* 
Un dispositivo fitness almacena día a día, en una matriz de NxM, los entrenamientos de running que realiza
un atleta. Cada entrenamiento consiste en realizar pasadas de K kilómetros registrando cada 1 km el tiempo
en segundos que tardó. De cada entrenamiento se registra la actividad en secuencias separadas por cero/s,
cada secuencia representa una pasada. Por ejemplo, en la siguiente matriz, el sexto y séptimo día el atleta
hizo 1 sola pasada, el tercer día realizó 5 pasadas (secuencias) y en el resto de los días, 4 pasadas en cada
uno. También se puede ver que en la primera pasada del primer día de entrenamiento el atleta recorrió 4 km,
tardando 300, 298, 298 y 297 segundos en cada kilómetro recorrido.

| 0 | 300 | 298 | 298 | 297 | 0   | 240 | 233 | 245 | 240 | 0 | 257 | 254 | 254 | 0 | 234 | 230 | 222 | 0 | 0 |
| 0 | 310 | 302 | 284 | 271 | 0   | 280 | 263 | 263 | 0   | 0 | 0   | 264 | 264 | 0 | 234 | 230 | 0   | 0 | 0 |
| 0 | 310 | 302 | 294 | 0   | 0   | 250 | 243 | 0   | 245 | 0 | 257 | 255 | 253 | 0 | 234 | 229 | 0   | 0 | 0 |
| 0 | 315 | 320 | 395 | 398 | 0   | 351 | 333 | 353 | 0   | 0 | 0   | 334 | 354 | 0 | 454 | 490 | 499 | 0 | 0 |
| 0 | 410 | 400 | 397 | 0   | 0   | 250 | 243 | 0   | 0   | 0 | 257 | 255 | 253 | 0 | 234 | 229 | 220 | 0 | 0 |
| 0 | 0   | 420 | 430 | 430 | 450 | 420 | 0   | 0   | 0   | 0 | 0   | 0   | 0   | 0 | 0   | 0   | 0   | 0 | 0 |
| 0 | 415 | 425 | 435 | 420 | 0   | 0   | 0   | 0   | 0   | 0 | 0   | 0   | 0   | 0 | 0   | 0   | 0   | 0 | 0 |

Por otra parte, el entrenador brinda al atleta la planificación semanal donde especifica los días (se numeran del
1 al 7) en los cuales debe hacer un entrenamiento progresivo (el arreglo es rellenado con 0 cuando no hay más días
indicados). Un entrenamiento progresivo consiste en realizar pasadas en donde cada kilómetro es recorrido a mayor
o igual velocidad que el anterior (en menor o igual tiempo). Por ejemplo, dado un arreglo:

| 1 | 2 | 5 | 0 | 0 | 0 | 0 |

En este caso el entrenamiento progresivo debe ser el primer, segundo y quinto día de la semana y se debe cumplir en
todos los intervalos (secuencias) de cada día. Los días no incluidos en este arreglo son de entrenamiento libre. Con
esta información, el entrenador quiere saber si el atleta cumplió o no con el entrenamiento. Se pide realizar un
programa en JAVA que dada una matriz de NxM, un arreglo de tamaño N y un porcentaje P: (a) elimine del arreglo
aquellos días en los cuales se cumplió con el entrenamiento establecido; (b) informe al entrenador si el atleta
ha cumplido con el entrenamiento en al menos P por ciento de los días que se le asignó el entrenamiento progresivo.
Para este ejemplo, el atleta cumplió con el entrenamiento progresivo 2 de los 3 días (día 2 y 5), por lo que su
porcentaje de cumplimiento fue de 2 / 3 = 0.66 o 66% de lo requerido. En este caso, para un P = 0.5 (50%) el atleta
cumplió con lo pedido por el entrenador.
*/

public class RecuperatorioEjercicio01 {
    public static final int MAXF = 7, MAXC = 20, MAX_ARR = MAXF, SEPARADOR = 0;
    public static double PORCENTAJE_MIN = 0.5;

    public static void main(String[] args) {
        int[][] matrizEntrenamiento = {
                { 0, 300, 298, 298, 297, 0, 240, 233, 245, 240, 0, 257, 254, 254, 0, 234, 230, 222, 0, 0 },
                { 0, 310, 302, 284, 271, 0, 280, 263, 263, 0, 0, 0, 264, 264, 0, 234, 230, 0, 0, 0 },
                { 0, 310, 302, 294, 0, 0, 250, 243, 0, 245, 0, 257, 255, 253, 0, 234, 229, 0, 0, 0 },
                { 0, 315, 320, 395, 398, 0, 351, 333, 353, 0, 0, 0, 334, 354, 0, 454, 490, 499, 0, 0 },
                { 0, 410, 400, 397, 0, 0, 250, 243, 0, 0, 0, 257, 255, 253, 0, 234, 229, 220, 0, 0 },
                { 0, 0, 420, 430, 430, 450, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 415, 425, 435, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        int[] arregloEntrenamiento = { 1, 2, 5, 0, 0, 0, 0 };

        // Se imprime la matriz original y la planificación semanal
        System.out.println("Matriz entrenamiento:");
        imprimirMatriz(matrizEntrenamiento, MAXC);
        System.out.println("Planificación semanal:");
        imprimirArreglo(arregloEntrenamiento, MAX_ARR);

        // Procesamiento
        procesarEntrenamiento(matrizEntrenamiento, arregloEntrenamiento);
        
        // Se imprime la planificación semanal modificada
        System.out.println("Planificación semanal modificada:");
        imprimirArreglo(arregloEntrenamiento, MAX_ARR);
    }

    // Verifica si se cumplió con el porcentaje de entrenamiento progresivo
    public static void procesarEntrenamiento(int[][] matrizEntrenamiento, int[] arregloEntrenamiento) {
        int i = 0, diasEntrenamiento = 0, diasCumplidos = 0;
        double porcentaje;

        // Se recorre el arreglo de la planificación semanal hasta encontrar un separador
        while (i < MAX_ARR && arregloEntrenamiento[i] != SEPARADOR) {
            // Se verifica si se cumple con el entrenamiento progresivo un día dado
            if (cumpleEntrenamientoProgresivo(matrizEntrenamiento[arregloEntrenamiento[i] - 1])) {
                // Si se cumple, se incrementa la variable 'diasCumplidos' y se elimina de la planificación semanal
                diasCumplidos++;
                correrAIzquierda(arregloEntrenamiento, i);
            } else {
                // Si no se cumple, se incrementa la variable de control 'i'
                i++;
            }

            // Cada iteración del while incrementa 'diasEntrenamiento' en 1
            diasEntrenamiento++;
        }

        // Se calcula el porcentaje de días cumplidos sobre el total de días
        porcentaje = (double) diasCumplidos / diasEntrenamiento;

        // Se informa si el atleta cumplió o no con el porcentaje de entrenamiento pautado
        if (porcentaje > PORCENTAJE_MIN) {
            System.out.println("Se cumplió con el porcentaje de entrenamiento pautado.");
        } else {
            System.out.println("No se cumplió con el porcentaje de entrenamiento pautado.");
        }
    }

    // Verifica si se cumplió el entrenamiento progresivo un día dado
    public static boolean cumpleEntrenamientoProgresivo(int[] dia) {
        int ini = 0, fin = -1;
        boolean cumple = true;

        while (ini < MAXC && cumple) {
            ini = obtenerInicioSecuencia(dia, fin + 1);

            if (ini < MAXC) {
                fin = obtenerFinSecuencia(dia, ini);
                cumple = esPasadaProgresiva(dia, ini, fin);
            }
        }

        return cumple;
    }

    // Verifica si una pasada (secuencia) dada es progresiva
    public static boolean esPasadaProgresiva(int[] arr, int ini, int fin) {
        while (ini < fin && arr[ini] >= arr[ini + 1]) {
            ini++;
        }
        return ini == fin;
    }
    
    // Elimina el elemento de un arreglo en la posición dada
    public static void correrAIzquierda(int[] arr, int pos) {
        for (int i = pos; i < MAX_ARR - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // Devuelve la posición inicial de una secuencia
    public static int obtenerInicioSecuencia(int[] arr, int pos) {
        while (pos < MAXC && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición final de una secuencia
    public static int obtenerFinSecuencia(int[] arr, int pos) {
        while (pos < MAXC && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    // Imprime por consola una matriz dada
    public static void imprimirMatriz(int[][] matriz, int cantElementos) {
        for (int fila = 0; fila < MAXF; fila++) {
            imprimirArreglo(matriz[fila], cantElementos);
        }
    }

    // Imprime por consola un arreglo dado
    public static void imprimirArreglo(int[] arr, int cantElementos) {
        System.out.print("| ");
        for (int i = 0; i < cantElementos; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}
