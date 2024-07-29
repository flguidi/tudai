package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 17 --- */

/*
Escribir un programa que mientras que el usuario ingrese un carácter letra minúscula, pida ingresar un número
entero. Si el número ingresado está entre 1 y 5 inclusive deberá imprimir la tabla de multiplicar de dicho número.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E17 {
    public static void main(String[] args) {
        char caracter;
        int num;

        System.out.print("Ingresar un carácter letra minúscula (otro para terminar programa): ");
        caracter = leerCaracter();
        
        while ('a' <= caracter && caracter <= 'z') {
            System.out.print("Ingresar número entero del 1 al 5: ");
            num = leerEntero();

            if (1 <= num && num <= 5) {
                imprimirTablaMultiplicar(num);
            }

            System.out.print("Ingresar un carácter letra minúscula (otro para terminar programa): ");
            caracter = leerCaracter();
        }
    }

    public static char leerCaracter() {
        char caracter = ' ';
        boolean esCaracter = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (!esCaracter) {
            try {
                caracter = entrada.readLine().charAt(0);
                esCaracter = true;
            } catch (Exception e) {
                System.out.print("Error. Intentar nuevamente: ");
            }
        }

        return caracter;
    }

    public static int leerEntero() {
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

    public static void imprimirTablaMultiplicar(int tabla) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(tabla + " * " + i + " = " + (tabla * i));
        }
    }
}
