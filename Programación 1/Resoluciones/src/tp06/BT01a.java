package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Bonus Track 01a --- */

/* 
Dado que el volumen de ventas ha aumentado, el gerente de sistemas de la cadena de supermercados Carrefive plantea
la necesidad de modificar la estructura de almacenamiento de los datos. Hasta el momento se guardaban en un arreglo
que tenía secuencias, para cada ticket de venta, separadas por cero. Dado que el arreglo debía ser enorme para
almacenar todos los datos de ventas, se propone cambiar por una matriz en donde cada fila representa las ventas
para un día. La matriz por lo tanto tendrá 31 filas y cada fila tendrá MAXC columnas (suficientes para almacenar
todas las ventas de un día). Para poder almacenar las ventas totales del año se podrían tener 12 matrices de las
mismas características. Con estos cambios presentados, el departamento de ventas se muestra interesado en obtener
más información que le sirve para asistir en la toma de decisiones en pos de mejorar la economía estimando los
ingresos que tienen. Por ello solicita al gerente de sistemas que le prepare algunas rutinas para conocer:
    a. cuántos tickets en promedio se emiten por día para un mes particular.
    b. cuál es el importe medio de venta para 1 día, 1 semana (considerar la primera semana del mes) y para un mes.
    c. cuál es el ticket de mayor importe del mes.
    d. cuál es el ticket con más productos vendidos en 1 día particular.
    e. qué día del mes se vendió la mayor cantidad de productos. 
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT01a {
    public static final int MAXF = 31; // Días de la semana
    public static final int MAXC = 30;
    public static final int SEPARADOR = 0;
    public static final int MIN_VALOR = 200, MAX_VALOR = 9999;
    public static final double PROBABILIDAD_ELEMENTO = 0.6;

    public static void main(String[] args) {
        int[][] mes = new int[MAXF][MAXC];
        char opcion = ' ';
        
        // Carga aleatoria de matriz de secuencias numéricas
        cargarMatrizSecuenciasInt(mes);

        // Menú
        while (opcion != '0') {
            imprimirMenu();
            System.out.print("Elija una opción: ");
            opcion = leerChar();

            switch (opcion) {
                case 'a':
                    // Se obtiene la cantidad de tickets promedio por día en un mes
                    double cantTicketsPromedio = obtenerCantTicketsPromedio(mes, MAXF);
                    System.out.println("Cantidad promedio: " + cantTicketsPromedio);
                    break;
                
                case 'b':
                    // Se calculan los importes promedio
                    double importePromedioDia = obtenerImportePromedio(mes, 1); // por día
                    double importePromedioSemana = obtenerImportePromedio(mes, 7); // por semana
                    double importePromedioMes = obtenerImportePromedio(mes, MAXF); // por mes
                    System.out.println("Importe promedio por día: " + importePromedioDia);
                    System.out.println("Importe promedio por semana: " + importePromedioSemana);
                    System.out.println("Importe promedio por mes: " + importePromedioMes);
                    break;
            
                case 'c':
                    // Se obtiene e imprime el número de ticket de mayor importe en un mes
                    int numTicketMayorImporte = obtenerNumTicketMayorImporte(mes);
                    System.out.println("Ticket #" + numTicketMayorImporte);
                    break;

                case 'd':
                    // Imprime el ticket con más artículos vendidos en un día dado
                    System.out.print("Ingrese un día (1 a " + MAXF + "): ");
                    int dia = leerInt();
                    
                    if (1 <= dia && dia <= MAXF) {
                        int numTicketMasArticulos = obtenerNumTicketMasArticulos(mes[dia - 1]);
                        System.out.println("Ticket #" + numTicketMasArticulos);
                    } else {
                        System.out.println("Día incorrecto.");
                    }
                    break;

                case 'e':
                    // Imprime el día con mayor cantidad de ventas del mes
                    int diaMayorCantVentas = obtenerDiaMayorCantVentas(mes);
                    System.out.println("Día de mayor cantidad de ventas: " + diaMayorCantVentas);
                    break;

                case 'i':
                    // Imprime la matriz 'mes'
                    imprimirMatrizInt(mes);
                    break;

                case '0':
                    // Finaliza el programa
                    System.out.println("Gracias, vuelvan prontos :)");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }

    // Devuelve el día de un mes dado con mayor cantidad de ventas
    public static int obtenerDiaMayorCantVentas(int[][] mes) {
        int diaMayorCantVentas = 0, mayorCantTickets = 0;

        for (int dia = 0; dia < MAXF; dia++) {
            int ini = 0, fin = -1, cantTickets = 0;
            while (ini < MAXC) {
                ini = obtenerInicio(mes[dia], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(mes[dia], ini);
                    cantTickets++;
                }
            }
            if (cantTickets > mayorCantTickets) {
                mayorCantTickets = cantTickets;
                diaMayorCantVentas = dia + 1;
            }
            System.out.println((dia + 1) + ": " + cantTickets);
        }

        return diaMayorCantVentas;
    }

    // Devuelve el número de ticket con mayor cantidad de artículos de un día dado
    public static int obtenerNumTicketMasArticulos(int[] dia) {
        int ini = 0, fin = -1, numTicket = 0, cantArt = 0, cantMayorArt = 0, numTicketMasArt = 0;

        while (ini < MAXC) {
            ini = obtenerInicio(dia, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(dia, ini);
                numTicket++;
                cantArt = fin - ini + 1;
                if (cantArt > cantMayorArt) {
                    cantMayorArt = cantArt;
                    numTicketMasArt = numTicket;
                }
            }
        }

        return numTicketMasArt;
    }

    // Devuelve el número de ticket de mayor importe de un mes dado
    public static int obtenerNumTicketMayorImporte(int[][] mes) {
        int numTicketMayorImporte = 0, numTicket = 0, importeTicket, importeTicketMayor = 0;

        for (int dia = 0; dia < MAXF; dia++) {
            int ini = 0, fin = -1;
            while (ini < MAXC) {
                ini = obtenerInicio(mes[dia], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(mes[dia], ini);
                    numTicket++;
                    importeTicket = obtenerImporteTicket(mes[dia], ini, fin);
                    if (importeTicket > importeTicketMayor) {
                        importeTicketMayor = importeTicket;
                        numTicketMayorImporte = numTicket;
                    }
                }
            }
        }

        return numTicketMayorImporte;
    }

    // Devuelve el importe promedio de una cantidad de días dada
    public static double obtenerImportePromedio(int[][] mes, int cantDias) {
        int importeTotal = 0, cantTickets = 0;

        for (int dia = 0; dia < cantDias; dia++) {
            int ini = 0, fin = -1;
            while (ini < MAXC) {
                ini = obtenerInicio(mes[dia], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(mes[dia], ini);
                    importeTotal += obtenerImporteTicket(mes[dia], ini, fin); 
                    cantTickets++;
                }
            }
        }

        return (double) importeTotal / cantTickets; // Se retorna el importe promedio
    }

    // Devuelve el importe de un ticket dado
    public static int obtenerImporteTicket(int[] dia, int ini, int fin) {
        int importe = 0;
        for (int i = ini; i <= fin; i++) {
            importe += dia[i];
        }
        return importe;
    }

    // Calcula la cantidad de tickets promedio en una cantidad de días dada
    public static double obtenerCantTicketsPromedio(int[][] mes, int cantDias) {
        int cantTickets = 0;
        double cantTicketsPromedio;

        for (int dia = 0; dia < cantDias; dia++) {
            int ini = 0, fin = -1;
            while (ini < MAXC) {
                ini = obtenerInicio(mes[dia], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(mes[dia], ini);
                    cantTickets++;
                }
            }
        }

        cantTicketsPromedio = (double) cantTickets / cantDias;
        return cantTicketsPromedio;
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
    
    // Carga una matriz con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarMatrizSecuenciasInt(int[][] matriz) {
        Random r = new Random();

        for (int i = 0; i < MAXF; i++) {
            // Se coloca un separador al comienzo y final de cada fila
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
            System.out.print("|");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println();
        }
    }

    // Imprime un menú de opciones
    public static void imprimirMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENÚ");
        System.out.println("a. Cantidad de tickets en promedio por día de determinado mes.");
        System.out.println("b. Importe medio de venta para un día, una semana y un mes.");
        System.out.println("c. Ticket de mayor importe del mes.");
        System.out.println("d. Ticket con más productos vendidos en un determinado día.");
        System.out.println("e. Día del més en que se vendió la mayor cantidad de productos");
        System.out.println("i. Imprimir tabla.");
        System.out.println("0. Salir");
        System.out.println("--------------------------------------------------------------");
    }

    // Obtiene la entrada por teclado de un char
    public static char leerChar() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        char caracter = ' ';
        boolean esValido = false;

        while (!esValido) {
            try {
                caracter = entrada.readLine().charAt(0);
                esValido = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return caracter;
    }

    // Obtiene la entrada por teclado de un int
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
}

