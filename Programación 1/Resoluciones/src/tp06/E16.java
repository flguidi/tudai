package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 16 --- */

/* 
Hay dos matrices 'mat1' y 'mat2' de secuencias de caracteres letras separados por espacios de MAXF = 4 x MAXC = 20
que están precargadas. Cada fila empieza y termina con separadores ' ' (espacios). Además se tiene un método que
retorna el índice inicial de la secuencia de mayor tamaño de un arreglo de secuencias de tamaño MAXC.
Se pide realizar un programa que:
    a. Contenga los métodos de carga de la matriz y el mencionado en el enunciado.
    b. Para 'mat1' y 'mat2' elimine de cada secuencia el primer carácter vocal.
    c. Para 'mat1' agregue al principio de cada secuencia el primer carácter de la secuencia de mayor tamaño de
       dicha fila. Considere agregar un espacio al final de la fila para mantener la estructura de secuencia
       delimitada por separadores espacio.
    d. En cada fila, si se verifica que la secuencia de mayor tamaño de la fila para 'mat1' es mayor que la primera
       secuencia en dicha fila para 'mat2', las intercambie (la que está en 'mat1' pasa a 'mat2' y la que está en
       'mat2' pasa a 'mat1') sin usar estructuras auxiliares.
    e. Para un valor de fila ingresado por el usuario verifique e imprima si la primera secuencia de 'mat1' en dicha
       fila es igual a la primera secuencia de 'mat2' en dicha fila.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E16 {
    public static final int MAXF = 4, MAXC = 20, CANT_LETRAS = 26;
    public static final double PROBABILIDAD_ELEMENTO = 0.5;
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        char[][] mat1 = new char[MAXF][MAXC];
        char[][] mat2 = new char[MAXF][MAXC];
        int opcion;

        // Se cargan ambas matrices (punto A)
        cargarMatrizSecuenciasChar(mat1);
        cargarMatrizSecuenciasChar(mat2);
        
        // Se imprimen por consola ambas matrices
        System.out.println("Matriz 1:");
        imprimirMatrizChar(mat1);
        System.out.println("Matriz 2:");
        imprimirMatrizChar(mat2);

        // Menú
        System.out.println("MENÚ");
        System.out.println("1. Eliminar la primera vocal de cada secuencia");    
        System.out.println("2. Agregar al principio de cada secuencia de 'mat1' el primer carácter de la secuencia de mayor tamaño");
        System.out.println("3. Intercambiar secuencia mayor de 'mat1' con primera secuencia de 'mat2' en filas iguales");
        System.out.println("4. Comparar primera secuencia de 'mat1' con primera secuencia de 'mat2'");
        System.out.print("Elija una opción: ");
        opcion = leerInt();

        switch (opcion) {
            case 1:
                // Punto B
                eliminarPrimeraVocal(mat1);
                eliminarPrimeraVocal(mat2);
                System.out.println("Matriz 1 modificada:");
                imprimirMatrizChar(mat1);
                System.out.println("Matriz 2 modificada:");
                imprimirMatrizChar(mat2);
                break;

            case 2:
                // Punto C
                reemplazarPrimerCaracterEnSecuencias(mat1);
                System.out.println("Matriz 1 modificada:");
                imprimirMatrizChar(mat1);
                break;

            case 3:
                // Punto D
                compararEIntercambiarSecuencias(mat1, mat2);
                System.out.println("Matriz 1 modificada:");
                imprimirMatrizChar(mat1);
                System.out.println("Matriz 2 modificada:");
                imprimirMatrizChar(mat2);
                break;

            case 4:
                // Punto E
                System.out.print("Ingrese un número de fila: ");
                int fila = leerInt();
                if (0 <= fila && fila < MAXF) {
                    boolean sonIguales = compararPrimerasSecuencias(mat1[fila], mat2[fila]);
                    if (sonIguales) {
                        System.out.println("Primera secuencia de mat1[" + fila + "] == Primera secuencia de mat2[" + fila + "]");
                    } else {
                        System.out.println("Primera secuencia de mat1[" + fila + "] != Primera secuencia de mat2[" + fila + "]");
                    }
                } else {
                    System.out.println("Número de fila incorrecto.");
                }
                break;

            default:
                System.out.println("Opción incorrecta.");
        }
    }

    // Compara las primeras secuencias entre dos vectores dados (punto E)
    public static boolean compararPrimerasSecuencias(char[] vector1, char[] vector2) {
        int fin1, ini1, ini2, fin2, longitud1, longitud2;
        boolean sonIguales;

        // Se obtienen los índices de inicio y fin de las primeras secuencias de ambos vectores
        ini1 = obtenerInicio(vector1, 0);
        fin1 = obtenerFin(vector1, ini1);
        ini2 = obtenerInicio(vector2, 0);
        fin2 = obtenerFin(vector2, ini2);

        longitud1 = fin1 - ini1 + 1;
        longitud2 = fin2 - ini2 + 1;

        sonIguales = compararSecuencias(vector1, ini1, fin1, vector2, ini2);

        return (longitud1 == longitud2) && sonIguales;
    }

    // Compara dos secuencias dadas
    public static boolean compararSecuencias(char[] vector1, int ini1, int fin1, char[] vector2, int ini2) {
        while (ini1 <= fin1 && vector1[ini1] == vector2[ini2]) {
            ini1++;
            ini2++;
        }
        return ini1 > fin1;
    }

    // Si la secuencia de mayor tamaño de 'mat1' es igual o mayor a la primera secuencia de 'mat2', las intercambia
    public static void compararEIntercambiarSecuencias(char[][] mat1, char[][] mat2) {
        // Para cada fila...
        for (int fila = 0; fila < MAXF; fila++) {
            // ... se calcula la longitud de la secuencia mayor en mat1[fila]
            int iniSecMayor = obtenerInicioSecuenciaMayor(mat1[fila]);
            int finSecMayor = obtenerFin(mat1[fila], iniSecMayor);
            int longitudSecMayor = finSecMayor - iniSecMayor + 1;
        
            // ... se calcula la longitud de la primera secuencia en mat2[fila]
            int iniPrimeraSec = obtenerInicio(mat2[fila], 0);
            int finPrimeraSec = obtenerFin(mat2[fila], iniPrimeraSec);
            int longitudPrimeraSec = finPrimeraSec - iniPrimeraSec + 1;

            // ... se comparan las longitudes
            if (longitudSecMayor >= longitudPrimeraSec) {
                intercambiarSecuencias(mat1[fila], iniSecMayor, finSecMayor, mat2[fila], iniPrimeraSec, finPrimeraSec);
            }
        }
    }

    // Intercambia dos secuencias entre dos vectores
    public static void intercambiarSecuencias(char[] vector1, int ini1, int fin1, char[] vector2, int ini2, int fin2) {
        int longitud1 = fin1 - ini1 + 1;
        int longitud2 = fin2 - ini2 + 1;
        int diferenciaLongitud;

        if (longitud1 >= longitud2) {
            // Si la longitud de la secuencia 1 es mayor a la 2
            diferenciaLongitud = longitud1 - longitud2;
            
            // Corrimiento a derecha del vector 2
            for (int i = 0; i < diferenciaLongitud; i++) {
                correrADerechaVector(vector2, fin2);
            }

            // Intercambio de elementos
            for (int i = 0; i < longitud1; i++) {
                char aux = vector1[i + ini1];
                vector1[i + ini1] = vector2[i + ini2];
                vector2[i + ini2] = aux;
            }

            // Eliminación de elementos sobrantes en el vector 1 e inserción de separador al final del vector 2
            for (int i = 0; i < diferenciaLongitud; i++) {
                eliminarElemento(vector1, fin1 - diferenciaLongitud);
            }
            vector2[MAXC - 1] = SEPARADOR;
        
        } else {
            // Si la longitud de la secuencia 2 es mayor a la 1
            diferenciaLongitud = longitud2 - longitud1;
            
            // Corrimiento a derecha del vector 1
            for (int i = 0; i < diferenciaLongitud; i++) {
                correrADerechaVector(vector1, fin1);
            }

            // Intercambio de elementos
            for (int i = 0; i < longitud2; i++) {
                char aux = vector2[i + ini2];
                vector2[i + ini2] = vector1[i + ini1];
                vector1[i + ini1] = aux;
            }

            // Eliminación de elementos sobrantes en el vector 2 e inserción de separador al final del vector 1
            for (int i = 0; i < diferenciaLongitud; i++) {
                eliminarElemento(vector2, fin2 - diferenciaLongitud);
            }
            vector1[MAXC - 1] = SEPARADOR;
        }
    }

    // Reemplaza el primer carácter de cada secuencia por el primer caracter de la secuencia de mayor tamaño (punto C)
    public static void reemplazarPrimerCaracterEnSecuencias(char[][] matriz) {
        // Se repite el proceso para cada fila
        for (int fila = 0; fila < MAXF; fila++) {
            int ini = 0, fin = -1;
            int iniSecMayor = obtenerInicioSecuenciaMayor(matriz[fila]);
            char primerCaracterSecMayor = matriz[fila][iniSecMayor];

            while (ini < MAXC) {
                ini = obtenerInicio(matriz[fila], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(matriz[fila], ini);
                    // Se desplaza a derecha y se inserta el primer carácter de la secuencia de mayor tamaño
                    correrADerechaVector(matriz[fila], ini);
                    matriz[fila][ini] = primerCaracterSecMayor;

                    matriz[fila][MAXC - 1] = ' '; // Se agrega un separador al final de cada fila
                    fin++; // Se actualiza el índice de fin de secuencia
                }
            }
        }
    }

    // Corrimiento a derecha a partir de una posición dada
    public static void correrADerechaVector(char[] vector, int pos) {
        for (int i = MAXC - 1; i > pos; i--) {
            vector[i] = vector[i - 1];
        }
    }

    // Elimina el elemento en una posición dada (corrimiento a izquierda)
    public static void eliminarElemento(char[] vector, int pos) {
        for (int i = pos; i < MAXC - 1; i++) {
            vector[i] = vector[i + 1];
        }
    }

    // Devuelve el índice inicial de la secuencia de mayor tamaño (punto A)
    public static int obtenerInicioSecuenciaMayor(char[] vector) {
        int ini = 0, fin = -1, longitudSec, iniSecMayor = 0, longitudMayor = 0;
        while (ini < MAXC) {
            ini = obtenerInicio(vector, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(vector, ini);
                longitudSec = fin - ini + 1;
                if (longitudSec > longitudMayor) {
                    longitudMayor = longitudSec;
                    iniSecMayor = ini;
                }
            }
        }

        return iniSecMayor;
    }

    // Elimina el primer carácter vocal de cada secuencia en cada fila (punto B)
    public static void eliminarPrimeraVocal(char[][] matriz) {
        // Se repite el proceso para cada fila
        for (int fila = 0; fila < MAXF; fila++) {
            int ini = 0, fin = -1, posPrimeraVocal;
            while (ini < MAXC) {
                ini = obtenerInicio(matriz[fila], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(matriz[fila], ini);

                    // Se verifica si la secuencia actual tiene al menos una vocal
                    posPrimeraVocal = buscarPrimeraVocal(matriz[fila], ini, fin);
                    if (posPrimeraVocal <= fin) {
                        // Se elimina la primera vocal y se actualiza el índice final
                        eliminarElemento(matriz[fila], posPrimeraVocal);
                        fin -= 1;
                    }
                }
            }
        }
    }

    // Devuelve la posición de la primera vocal encontrada
    public static int buscarPrimeraVocal(char[] vector, int ini, int fin) {
        int pos = ini;
        while (pos <= fin && (vector[pos] != 'a' && vector[pos] != 'e' && vector[pos] != 'i'
                && vector[pos] != 'o' && vector[pos] != 'u')) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición de inicio de una secuencia
    public static int obtenerInicio(char[] vector, int pos) {
        while (pos < MAXC && vector[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición de final de una secuencia
    public static int obtenerFin(char[] vector, int pos) {
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

    // Carga una matriz con caracteres aleatorios (punto A)
    public static void cargarMatrizSecuenciasChar(char[][] matriz) {
        Random r = new Random();
        for (int i = 0; i < MAXF; i++) {
            // Se coloca un separador al comienzo y final de cada fila
            matriz[i][0] = SEPARADOR;
            matriz[i][MAXC - 1] = SEPARADOR;
            for (int j = 1; j < MAXC - 1; j++) {
                if (PROBABILIDAD_ELEMENTO > r.nextDouble()) {
                    matriz[i][j] = (char) (r.nextInt(CANT_LETRAS) + 'a');
                } else {
                    matriz[i][j] = SEPARADOR;
                }
            }
        }
    }

    // Imprime por consola una matriz dada
    public static void imprimirMatrizChar(char[][] matriz) {
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < MAXF; i++) {
            System.out.print("| ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
