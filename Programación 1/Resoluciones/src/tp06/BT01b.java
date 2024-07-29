package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Bonus Track 01b --- */

/*
Dado que el equipo de desarrollo es muy eficiente, el departamento de ventas le ha generado un nuevo requerimiento
para que el sistema pueda emitir algunos informes extras:
    a. dado un importe, el sistema le debe informar cuántos tickets superan dicho importe para un día particular
       y para el mes completo.
    b. dada una cantidad de artículos, el sistema le debe informar cuántos tickets están por encima de esa cantidad
       para un día particular y para el mes entero.
    c. dado un importe, el sistema debe informar cuántos artículos vendidos están por encima del mismo para un día
       particular.
    d. dado un importe promedio, cuántos tickets superan en promedio a dicho importe para un día particular y para
       el mes completo.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT01b {
    public static final int MAXF = 31; // Días de la semana
    public static final int MAXC = 30;
    public static final int SEPARADOR = 0;
    public static final int MIN_VALOR = 200, MAX_VALOR = 9999;
    public static final double PROBABILIDAD_ELEMENTO = 0.6;

    public static void main(String[] args) {
        int[][] mes = new int[MAXF][MAXC];
        int dia, importe;
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
                    // Cantidad de tickets que superan importe ingresado en un día particular y en el mes
                    System.out.print("Ingrese un importe: ");
                    importe = leerInt();
                    System.out.print("Ingrese un día (1 a " + MAXF + "): ");
                    dia = leerInt();
                    
                    if (1 <= dia && dia <= MAXF) {
                        int cantTicketsMayorImporteMes = obtenerCantTicketsMayorImporteMes(mes, importe);
                        int cantTicketsMayorImporteDia = obtenerCantTicketsMayorImporteDia(mes[dia - 1], importe);
                        System.out.println("Cantidad de tickets que superan dicho importe en el mes: "
                                + cantTicketsMayorImporteMes);
                        System.out.println("Cantidad de tickets que superan dicho importe en el día "
                                + dia + ": " + cantTicketsMayorImporteDia);
                    } else {
                        System.out.println("Día incorrecto.");
                    }
                    break;
                
                case 'b':
                    // Cantidad de tickets por encima de una cantidad dada para un determinado día y en el mes
                    System.out.print("Ingrese la cantidad de artículos: ");
                    int cantArt = leerInt();
                    System.out.print("Ingrese un día (1 a " + MAXF + "): ");
                    dia = leerInt();

                    if (1 <= dia && dia <= MAXF) {
                        int cantTicketsMasArtMes = obtenerCantTicketsMasArtMes(mes, cantArt);
                        int cantTicketsMasArtDia = obtenerCantTicketsMasArtDia(mes[dia - 1], cantArt);
                        System.out.println("Cantidad de tickets que superan dicha cantidad de artículos en el mes: "
                                + cantTicketsMasArtMes);
                        System.out.println("Cantidad de tickets que superan dicha cantidad de artículos en el día "
                                + dia + ": " + cantTicketsMasArtDia);
                    } else {
                        System.out.println("Día incorrecto.");
                    }
                    break;
            
                case 'c':
                    // Cantidad de artículos vendidos por encima de un importe dado para un determinado día
                    System.out.print("Ingrese un importe: ");
                    importe = leerInt();
                    System.out.print("Ingrese un día (1 a " + MAXF + "): ");
                    dia = leerInt();

                    if (1 <= dia && dia <= MAXF) {
                        int cantArtMayorImporte = obtenerCantArtMayorImporte(mes[dia - 1], importe);
                        System.out.println("Cantidad de artículos con un monto mayor que $" + importe + ": "
                                + cantArtMayorImporte);
                    } else {
                        System.out.println("Día incorrecto.");
                    }
                    break;

                case 'd':
                    // Cantidad de tickets que superan en promedio a un importe promedio dado
                    System.out.print("Ingrese un importe promedio: ");
                    importe = leerInt();
                    System.out.print("Ingrese un día (1 a " + MAXF + "): ");
                    dia = leerInt();
                    if (1 <= dia && dia <= MAXF) {
                        int cantTicketsDia = obtenerCantTicketsQueSuperanPromedioDia(mes[dia], importe);
                        int cantTicketsMes = obtenerCantTicketsQueSuperanPromedioMes(mes, importe);
                        System.out.println("Cantidad de tickets del día " + dia + " que superan el promedio de $"
                                + importe + ": " + cantTicketsDia);
                        System.out.println("Cantidad de tickets del mes que superan el promedio de $" + importe
                                + ": " + cantTicketsMes);
                    } else {
                        System.out.println("Día incorrecto.");
                    }
                    break;

                case 'i':
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

    // Devuelve la cantidad de tickets de un día dado que superan en promedio al monto promedio ingresado
    public static int obtenerCantTicketsQueSuperanPromedioDia(int[] dia, int promedioIngresado) {
        int ini = 0, fin = -1, importeTicket, cantArt, cantTickets = 0;
        double promedioTicket;

        while (ini < MAXC) {
            ini = obtenerInicio(dia, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(dia, ini);
                importeTicket = obtenerImporteTicket(dia, ini, fin);
                cantArt = fin - ini + 1; 
                promedioTicket = (double) importeTicket / cantArt;
                if (promedioTicket > promedioIngresado) {
                    cantTickets++;
                }
            }
        }
        
        return cantTickets;
    }

    // Devuelve la cantidad de tickets en un mes que superan en promedio al monto promedio ingresado
    public static int obtenerCantTicketsQueSuperanPromedioMes(int[][] mes, int promedioIngresado) {       
        int importeTicket, cantArt, cantTickets = 0;
        double promedioTicket;

        for (int dia = 0; dia < MAXF; dia++) {
            int ini = 0, fin = -1;
            while (ini < MAXC) {
                ini = obtenerInicio(mes[dia], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(mes[dia], ini);
                    importeTicket = obtenerImporteTicket(mes[dia], ini, fin);
                    cantArt = fin - ini + 1; 
                    promedioTicket = (double) importeTicket / cantArt;
                    if (promedioTicket > promedioIngresado) {
                        cantTickets++;
                    }
                }
            }
        }

        return cantTickets;   
    }

    // Devuelve la cantidad de artículos de un día dado que superan el monto ingresado
    public static int obtenerCantArtMayorImporte(int[] dia, int importeIngresado) {
        int cantArtMayorImporte = 0;
        for (int i = 0; i < MAXC; i++) {
            if (dia[i] != SEPARADOR && dia[i] > importeIngresado) {
                cantArtMayorImporte++;
            }
        }
        return cantArtMayorImporte;
    }

    // Devuelve la cantidad de tickets de un determinado día que superan una cantidad dada de artículos
    public static int obtenerCantTicketsMasArtDia(int[] dia, int cantArtIngresada) {
        int ini = 0, fin = -1, cantArt, cantTicketsMasArt = 0;

        while (ini < MAXC) {
        ini = obtenerInicio(dia, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(dia, ini);
                cantArt = fin - ini + 1;
                if (cantArt > cantArtIngresada) {
                    cantTicketsMasArt++;
                }
            }
        }

        return cantTicketsMasArt;
    }

    // Devuelve la cantidad de tickets de un mes que superan una cantidad dada de artículos
    public static int obtenerCantTicketsMasArtMes(int[][] mes, int cantArtIngresada) {
        int cantArt, cantTicketsMasArt = 0;

        for (int dia = 0; dia < MAXF; dia++) {
            int ini = 0, fin = -1;
            while (ini < MAXC) {
            ini = obtenerInicio(mes[dia], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(mes[dia], ini);
                    cantArt = fin - ini + 1;
                    if (cantArt > cantArtIngresada) {
                        cantTicketsMasArt++;
                    }
                }
            }
        }

        return cantTicketsMasArt;
    }

    // Devuelve la cantidad de tickets de un determinado día que superan un importe dado
    public static int obtenerCantTicketsMayorImporteDia(int[] dia, int importeIngresado) {
        int ini = 0, fin = -1, cantTicketsMayorImporte = 0, importeTicket;

        while (ini < MAXC) {
        ini = obtenerInicio(dia, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(dia, ini);
                importeTicket = obtenerImporteTicket(dia, ini, fin);
                if (importeTicket > importeIngresado) {
                    cantTicketsMayorImporte++;
                }
            }
        }

        return cantTicketsMayorImporte;
    }

    // Devuelve la cantidad de tickets de un mes que superan un importe dado
    public static int obtenerCantTicketsMayorImporteMes(int[][] mes, int importeIngresado) {
        int cantTicketsMayorImporte = 0, importeTicket;

        for (int dia = 0; dia < MAXF; dia++) {
            int ini = 0, fin = -1;
            while (ini < MAXC) {
            ini = obtenerInicio(mes[dia], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(mes[dia], ini);
                    importeTicket = obtenerImporteTicket(mes[dia], ini, fin);
                    if (importeTicket > importeIngresado) {
                        cantTicketsMayorImporte++;
                    }
                }
            }
        }

        return cantTicketsMayorImporte;
    }

    // Devuelve el importe de un ticket dado
    public static int obtenerImporteTicket(int[] dia, int ini, int fin) {
        int importe = 0;
        for (int i = ini; i <= fin; i++) {
            importe += dia[i];
        }
        return importe;
    }

    // Devuelve la posición inicial de una secuencia
    public static int obtenerInicio(int[] vector, int pos) {
        while (pos < MAXC && vector[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición final de una secuencia
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
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("MENÚ");
        System.out.println("a. Cantidad de tickets que superan importe ingresado.");
        System.out.println("b. Cantidad de tickets que superan cantidad de artículos ingresada.");
        System.out.println("c. Cantidad de artículos que están por encima de monto ingresado.");
        System.out.println("d. Cantidad de tickets que superan en promedio al promedio ingresado.");
        System.out.println("i. Imprimir tabla.");
        System.out.println("0. Salir");
        System.out.println("-------------------------------------------------------------------------");
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
