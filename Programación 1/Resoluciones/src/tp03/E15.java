package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 15 --- */

/*
Escribir un programa que mientras que el usuario ingrese un número entero natural, llame a un método que
calcule la sumatoria entre 1 y dicho número y se lo retorne como resultado.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E15 {
    public static void main(String[] args) {
        int num, sumatoria;
        System.out.print("Ingresar número natural (otro para salir): ");
        num = ingresarEntero();

        while (num > 0) {
            sumatoria = sumatoria(1, num);
            System.out.println("Sumatoria entre 1 y " + num + " = " + sumatoria);

            System.out.print("Ingresar número natural (otro para salir): ");
            num = ingresarEntero();
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

    public static int sumatoria(int min, int max) {
        int suma = 0;
        for (int i = min; i <= max; i++) {
            suma += i;
        }
        return suma;
    }
}
