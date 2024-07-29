package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 06 --- */

/* Escribir un programa que mientras el usuario cargue desde teclado un carácter letra minúscula, llame a un
método que imprime por pantalla la tabla de multiplicar del 9. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E06 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        char caracter;
        
        System.out.print("Ingresar una letra minúscula (otro tipo de carácter para salir): ");
        caracter = ingresarCaracter();
        
        while ('a' <= caracter && caracter <= 'z') {
            imprimirTablaMultiplicar9();
            System.out.print("Ingresar letra minúscula (otro carácter para salir): ");
            caracter = ingresarCaracter();
        }
    }

    // Ingreso de carácter
    public static char ingresarCaracter() {
        char caracter = ' ';
        boolean esCaracter = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        while (!esCaracter) {
            try {
                caracter = entrada.readLine().charAt(0);
                esCaracter = true;
            } catch (Exception e) {
                System.out.print("Error: carácter no válido. Ingresar letra minúscula (otro carácter para salir): ");
            }
        }

        return caracter;
    }

    public static void imprimirTablaMultiplicar9() {
        for (int i = 1; i <= MAX; i++) {
            System.out.println(9 + " * " + i + " = " + (9 * i));
        }
    }
}
