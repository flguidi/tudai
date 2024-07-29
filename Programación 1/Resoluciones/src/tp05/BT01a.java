package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Bonus Track 01a --- */

/* 
El departamento de ventas de la cadena de supermercados Carrefive desea hacer un análisis sobre lo comercializado
en el último fin de semana largo. Para ello solicita al grupo de desarrollo que le prepare algunas rutinas para
conocer:
    a. cuántos tickets se emitieron ese fin de semana
    b. cuánto fue el importe total de ventas
    c. cuál fue el ticket de mayor importe y cuánto fue su valor
    d. cuál fue la mayor cantidad de artículos vendidos en un ticket
    e. del ticket con mayor cantidad de artículos vendidos, cuál fue el de mayor importe, el de menor y el promedio
    f. del ticket de mayor importe, cuántos artículos hay involucrados y cuál es el promedio de valores
    g. cuánto es el valor promedio de venta por ticket del fin de semana completo
    h. cuál fue el ticket con el menor importe y cuánto fue su valor
    i. cuál fue el ticket con la menor cantidad de artículos vendidos
Hacer un programa completo con un menú de opciones (con la opción '0' se sale) para que informe los diferentes
valores al departamento de ventas. Considerar constantes y variables acordes al problema. Establezca cómo será
la estructura que usará y defínala en el programa teniendo en cuenta los conceptos de secuencias vistos en la
teoría.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class BT01a {
    public static final int MAX = 50, MIN_VALOR = 120, MAX_VALOR = 3000;
    public static double PROBABILIDAD_NUMERO = 0.5;

    public static void main(String[] args) {
        int[] ventas = new int[MAX];
        char opcion = ' ';

        cargarArreglo(ventas);
        imprimirArreglo(ventas);

        // Menú
        imprimirMenu();

        while (opcion != '0') {
            // Entrada de opción
            System.out.print("\nIngrese una opción ('m' para ver el menú | '0' para salir): ");
            opcion = leerCaracter();

            // Elección de opción
            switch (opcion) {
                case 'a': contarTotalTickets(ventas); break;
                case 'b': calcularImporteTotal(ventas); break;
                case 'c': calcularTicketMayorImporte(ventas); break;
                case 'd': calcularTicketMayorCantArt(ventas); break;
                case 'e': calcularMenorMayorPromedioTicketMasArticulos(ventas); break;
                case 'f': calcularCantPromedioTicketMayorImporte(ventas); break;
                case 'g': calcularPromedioImporteTickets(ventas); break;
                case 'h': calcularTicketMenorImporte(ventas); break;
                case 'i': calcularTicketMenorCantArt(ventas); break;
                case 'm': imprimirMenu(); break;
                case '0': System.out.println("Gracias, vuelvan prontos :)\n"); break; // Finalización de programa
                default: System.out.println("Opción incorrecta. Inténtelo nuevamente.");
            }
        }
    }

    // Entrada de carácter por teclado
    public static char leerCaracter() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        char caracter = ' ';
        boolean esValido = false;

        while (!esValido) {
            try {
                caracter = entrada.readLine().charAt(0);
                esValido = true;
            } catch (Exception e) {
                System.out.println("Error. Inténtelo nuevamente.");
            }
        }

        return caracter;
    }

    // Carga aleatoria de arreglo con números enteros entre MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;

        for (int i = 1; i < MAX - 1; i++) {
            if (r.nextDouble() < PROBABILIDAD_NUMERO) {
                arr[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            }
        }
    }

    // Calcula e imprime la cantidad total de tickets emitidos (opción A)
    public static int contarTotalTickets(int[] arr) {
        int inicio = 0, fin = -1, cantTickets = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                cantTickets++;
            }
        }

        System.out.println("Cantidad de tickets: " + cantTickets);
        return cantTickets;
    }

    // Calcula e imprime el importe total de los tickets (opción B)
    public static int calcularImporteTotal(int[] arr) {
        int importeTotal = 0;

        for (int i = 0; i < MAX; i++) {
            // Se verifica que no se sumen los separadores (por si se desea utilizar otro número que no sea 0)
            if (arr[i] != 0) {
                importeTotal += arr[i];
            }
        }

        System.out.println("Importe total de ventas: " + importeTotal);
        return importeTotal;
    }

    // Imprime el número de ticket de mayor importe y su valor (opción C)
    public static void calcularTicketMayorImporte(int[] arr) {
        int inicio = 0, fin = -1, importe, mayorImporte = 0, numeroTicket = 0, numeroTicketMayorImporte = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                importe = calcularImporteTicket(arr, inicio, fin);
                numeroTicket++;
                if (importe > mayorImporte) {
                    numeroTicketMayorImporte = numeroTicket;
                    mayorImporte = importe;
                }
            }
        }

        System.out.println("Número de ticket de mayor importe: " + numeroTicketMayorImporte);
        System.out.println("Importe: " + mayorImporte);
    }

    // Devuelve el importe de un ticket dado
    public static int calcularImporteTicket(int[] arr, int inicio, int fin) {
        int importe = 0;
        for (int i = inicio; i <= fin; i++) {
            importe += arr[i];
        }
        return importe;
    }

    // Imprime el ticket con mayor cantidad de artículos (opción D)
    private static void calcularTicketMayorCantArt(int[] arr) {
        int inicio = 0, fin = -1, cantidadArticulos, mayorCantidadArticulos = 0,
            numeroTicket = 0, numeroTicketMayorCantidadArticulos = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                cantidadArticulos = fin - inicio + 1;
                numeroTicket++;
                if (cantidadArticulos > mayorCantidadArticulos) {
                    numeroTicketMayorCantidadArticulos = numeroTicket;
                    mayorCantidadArticulos = cantidadArticulos;
                }
            }
        }

        System.out.println("Número de ticket con mayor cantidad de artículos: " + numeroTicketMayorCantidadArticulos);
        System.out.println("Cantidad de artículos: " + mayorCantidadArticulos);
    }

    // Imprime el artículo de menor importe, el de mayor y el promedio del ticket con mayor cantidad de artículos (opción E)
    public static void calcularMenorMayorPromedioTicketMasArticulos(int[] arr) {
        int inicio = 0, fin = -1, cantArt, mayorCantArt = 0, inicioTicketMayorCantArt = 0, finTicketMayorCantArt = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                cantArt = fin - inicio + 1;
                if (cantArt > mayorCantArt) {
                    mayorCantArt = cantArt;
                    inicioTicketMayorCantArt = inicio;
                    finTicketMayorCantArt = fin;
                }
            }
        }

        int artMenorImporte = calcularArticuloMenorImporte(arr, inicioTicketMayorCantArt, finTicketMayorCantArt);
        int artMayorImporte = calcularArticuloMayorImporte(arr, inicioTicketMayorCantArt, finTicketMayorCantArt);
        double promedio = (double) calcularImporteTicket(arr, inicioTicketMayorCantArt, finTicketMayorCantArt) / mayorCantArt;

        System.out.println("Cantidad de artículos: " + mayorCantArt);
        System.out.println("Artículo con menor importe: " + artMenorImporte);
        System.out.println("Artículo con mayor importe: " + artMayorImporte);
        System.out.println("Promedio de importes del ticket: " + promedio);
    }

    // Imprime la cantidad de artículos y el promedio de valores del ticket de mayor importe (opción F)
    public static void calcularCantPromedioTicketMayorImporte(int[] arr) {
        int inicio = 0, fin = -1, inicioTicketMayorImporte = 0, finTicketMayorImporte = 0, 
            importe, mayorImporte = 0, numeroTicket = 0, numeroTicketMayorImporte = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                importe = calcularImporteTicket(arr, inicio, fin);
                numeroTicket++;
                if (importe > mayorImporte) {
                    numeroTicketMayorImporte = numeroTicket;
                    mayorImporte = importe;
                    inicioTicketMayorImporte = inicio;
                    finTicketMayorImporte = fin;
                }
            }
        }

        int cantArt = finTicketMayorImporte - inicioTicketMayorImporte;
        double promedio = (double) calcularImporteTicket(arr, inicioTicketMayorImporte, finTicketMayorImporte) / cantArt;

        System.out.println("Número de ticket de mayor importe: " + numeroTicketMayorImporte);
        System.out.println("Importe: " + mayorImporte);
        System.out.println("Cantidad de artículos: " + cantArt);
        System.out.println("Promedio: " + promedio);
    }

    // Imprime el promedio de venta por ticket (opción G)
    public static void calcularPromedioImporteTickets(int[] arr) {
        int importeTotal = calcularImporteTotal(arr);
        int tickets = contarTotalTickets(arr);
        double promedio = (double) importeTotal / tickets;
        System.out.println("Promedio por ticket: " + promedio);
    }

    // Imprime el número de ticket de menor importe y su valor total (opción H)
    public static void calcularTicketMenorImporte(int[] arr) {
        int inicio = 0, fin = -1, importe, menorImporte = Integer.MAX_VALUE, numeroTicket = 0, numeroTicketMenorImporte = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                importe = calcularImporteTicket(arr, inicio, fin);
                numeroTicket++;
                if (importe < menorImporte) {
                    numeroTicketMenorImporte = numeroTicket;
                    menorImporte = importe;
                }
            }
        }

        System.out.println("Número de ticket de menor importe: " + numeroTicketMenorImporte);
        System.out.println("Importe: " + menorImporte);
    }

    // Imprime el número de ticket con menor cantidad de artículos (opción I)
    private static void calcularTicketMenorCantArt(int[] arr) {
        int inicio = 0, fin = -1, cantArt, menorCantArt = MAX, numTicket = 0, numTicketMenorCantArt = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                cantArt = fin - inicio + 1;
                numTicket++;
                if (cantArt < menorCantArt) {
                    numTicketMenorCantArt = numTicket;
                    menorCantArt = cantArt;
                }
            }
        }

        System.out.println("Número de ticket con menor cantidad de artículos: " + numTicketMenorCantArt);
        System.out.println("Cantidad de artículos: " + menorCantArt);
    }

    // Devuelve el importe menor de un ticket dado
    public static int calcularArticuloMenorImporte(int[] arr, int inicio, int fin) {
        int importeMenor = arr[inicio];
        for (int i = inicio; i <= fin; i++) {
            if (arr[i] < importeMenor) {
                importeMenor = arr[i];
            }
        }
        return importeMenor;
    }

    // Devuelve el importe mayor de un ticket dado
    public static int calcularArticuloMayorImporte(int[] arr, int inicio, int fin) {
        int importeMayor = arr[inicio];
        for (int i = inicio; i <= fin; i++) {
            if (arr[i] > importeMayor) {
                importeMayor = arr[i];
            }
        }
        return importeMayor;
    }

    // Devuelve el índice de inicio de una secuencia
    public static int obtenerInicioSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    // Devuelve el índice de fin de una secuencia
    public static int obtenerFinSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    // Imprime el menú de opciones
    public static void imprimirMenu() {
        System.out.println("\nCARREFIVE --- INFORME DE VENTAS");
        System.out.println("a. Cantidad de tickets emitidos");
        System.out.println("b. Importe total de ventas");
        System.out.println("c. Ticket de mayor importe");
        System.out.println("d. Mayor cantidad de artículos vendidos en un ticket");
        System.out.println("e. Artículo de mayor y menor importe y el promedio (del ticket con más artículos vendidos)");
        System.out.println("f. Cantidad de artículos y promedio de valores (del ticket de mayor importe)");
        System.out.println("g. Valor promedio de venta por ticket");
        System.out.println("h. Ticket de menor importe");
        System.out.println("i. Ticket con menor cantidad de artículos vendidos");
    }

    // Imprime el arreglo de secuencias numéricas
    public static void imprimirArreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.println(arr[i]);
        }
    }
}
