package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Bonus Track 01b --- */

/* 
Dado que el equipo de desarrollo es muy eficiente, el departamento de ventas le ha generado un nuevo requerimiento
para que el sistema pueda emitir algunos informes extras:
    a. dado un importe, el sistema le debe informar cuantos tickets superan dicho importe
    b. dada una cantidad de artículos, el sistema le debe informarcuántos tickets están por encima de esa cantidad.
    c. dado un importe, el sistema debe informar cuantos artículos vendidos están por encima del mismo.
    d. dado un importe promedio, cuántos tickets superan en promedio a dicho importe
Hacer un programa completo con un menú de opciones (con la opción ‘0’ sale) para que informe los diferentes valores
al departamento de ventas.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class BT01b {
    public static final int MAX = 50, MIN_VALOR = 120, MAX_VALOR = 3000;
    public static double PROBABILIDAD_NUMERO = 0.5;

    public static void main(String[] args) {
        int[] ventas = new int[MAX];
        char opcion = ' ';

        cargarArreglo(ventas);
        imprimirArreglo(ventas);
        imprimirMenu(); // Menú

        while (opcion != '0') {
            // Entrada de opción
            System.out.print("\nIngrese una opción ('m' para ver el menú | '0' para salir): ");
            opcion = leerCaracter();

            // Elección de opción
            switch (opcion) {
                case 'a':
                    System.out.print("Ingrese un importe: ");
                    int importeTicket = leerEntero();
                    imprimirCantTicketsMayoresAImporte(ventas, importeTicket);
                    break;

                case 'b': 
                    System.out.print("Ingrese cantidad de artículos: ");
                    int cantArticulos = leerEntero();
                    imprimirCantTicketsConMasArt(ventas, cantArticulos);
                    break;

                case 'c': 
                    System.out.print("Ingrese importe: ");
                    int importeArticulo = leerEntero();
                    imprimirCantArtImporteMayor(ventas, importeArticulo);
                    break;

                case 'd': 
                    System.out.print("Ingrese promedio: ");
                    int promedio = leerEntero();
                    imprimirCantTicketsMayoresAImporte(ventas, promedio);
                    break;

                case 'm': 
                    imprimirMenu(); 
                    break;

                case '0': // Finalización de programa
                    System.out.println("Gracias, vuelvan prontos :)\n"); 
                    break;

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

    // Entrada de número entero por teclado
    public static int leerEntero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean esValido = false;
        
        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("Error. Inténtelo nuevamente.");
            }
        }
        
        return num;
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

    // Imprime la cantidad de tickets con mayor importe que el especificado (opciones A y D)
    private static void imprimirCantTicketsMayoresAImporte(int[] arr, int importe) {
        int inicio = 0, fin = -1, cantTickets = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                if (calcularImporteTicket(arr, inicio, fin) > importe) {
                    cantTickets++;
                }
            }
        }

        System.out.println("Cantidad de tickets con un importe mayor a $" + importe + ": " + cantTickets);
    }
    
    // Devuelve el importe de un ticket dado
    public static int calcularImporteTicket(int[] arr, int inicio, int fin) {
        int importe = 0;
        for (int i = inicio; i <= fin; i++) {
            importe += arr[i];
        }
        return importe;
    }

    // Imprime la cantidad de tickets con mayor cantidad de artículos que el especificado (opción B)
    private static void imprimirCantTicketsConMasArt(int[] arr, int cantArticulos) {
        int inicio = 0, fin = -1, cantTickets = 0, cantArticulosTicket;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                cantArticulosTicket = fin - inicio + 1;
                if (cantArticulosTicket > cantArticulos) {
                    cantTickets++;
                }
            }
        }

        System.out.println("Cantidad de tickets con más de " + cantArticulos + " artículos:" + cantTickets);
    }
    
    // Imprime la cantidad de articulos con mayor importe que el especificado (opción C)
    private static void imprimirCantArtImporteMayor(int[] arr, int importeArticulo) {
        int cantArticulos = 0;
        
        for (int i = 0; i < MAX; i++) {
            if (arr[i] > importeArticulo) {
                cantArticulos++;
            }
        }

        System.out.println("Cantidad de artículos que superan el monto de $" + importeArticulo + ": " + cantArticulos);
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

    // Imprime el arreglo de secuencias numéricas
    public static void imprimirArreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.println(arr[i]);
        }
    }

    // Imprime el menú de opciones
    public static void imprimirMenu() {
        System.out.println("\nCARREFIVE --- INFORME DE VENTAS");
        System.out.println("a. Cantidad de tickets que superan un importe especificado");
        System.out.println("b. Cantidad de tickets con una cantidad de articulos mayor a la especificada");
        System.out.println("c. Cantidad de artículos por encima de un importe especificado");
        System.out.println("d. Cantidad de tickets por encima de un importe promedio especificado");
    }
}
