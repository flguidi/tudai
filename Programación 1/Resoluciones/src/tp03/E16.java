package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 16 --- */

/*
Escribir un programa que mientras el usuario ingresa un número de mes (entero) entre 1 y 12 inclusive, muestre
por pantalla la cantidad de días del mes ingresado (suponer febrero de 28 días) (Mostrar por pantalla la cantidad
de días del mes debería realizarse con un método).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E16 {
    public static void main(String[] args) {
        int mes;
        System.out.print("Ingresar número de mes (1 a 12): ");
        mes = ingresarEntero();

        while (1 <= mes && mes <= 12) {
            imprimirDiasPorMes(mes);

            System.out.print("Ingresar número de mes (1 a 12): ");
            mes = ingresarEntero();
        }
    }

    public static int ingresarEntero() {
        int num = 0;
        boolean esEntero = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (!esEntero) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esEntero = true;
            } catch (Exception e) {
                System.out.print("Error. Intentar nuevamente: ");
            }
        }

        return num;
    }

    public static void imprimirDiasPorMes(int mes) {
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println("31 días");
                break;
            case 4, 6, 9, 11:
                System.out.println("30 días");
                break;
            case 2:
                System.out.println("28 días");
                break;
            default:
                System.out.println("Error");
        }
    }
}
