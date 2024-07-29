package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 14 --- */

/*
Escribir un programa que mientras el usuario ingresa un carácter distinto del carácter ‘*’, invoque un método
que imprima si es carácter dígito o carácter letra minúscula, y si es letra minúscula imprimir si es vocal o
consonante.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E14 {
    public static void main(String[] args) {
        char caracter;
        System.out.print("Ingresar carácter ('*' para salir): ");
        caracter = ingresarCaracter();

        while (caracter != '*') {
            verificarCaracter(caracter);
            System.out.print("Ingresar carácter ('*' para salir): ");
            caracter = ingresarCaracter();
        }
    }

    public static char ingresarCaracter() {
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

    public static void verificarCaracter(char c) {
        if ('0' <= c && c <= '9') {
            System.out.println("Dígito");
        } else if ('a' <= c && c <= 'z') {
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u': System.out.println("Vocal"); break;
                default: System.out.println("Consonante");
            }
        }
    }
}
