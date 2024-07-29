package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 07 --- */

/*
Escribir un programa que mientras el usuario cargue desde teclado un número entero distinto de 0, imprima
por pantalla la suma que se obtiene de invocar un método que calcula la sumatoria de los primeros 200 números
naturales.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E07 {
    public static final int MAX = 200;

    public static void main(String[] args) {
        int num = 0;
        
        System.out.println("DEBUGGING PARA PRÁCTICA 04, EJERCICIO 02:");

        System.out.print("Ingresar número entero (0 para salir): ");
        num = ingresarNumero();
        System.out.println("'num': " + num);

        System.out.println("num != 0: " + (num != 0));
        while (num != 0) {
            System.out.println("La sumatoria de los primeros 200 números naturales es: " + sumatoria200());
            System.out.print("Ingresar número entero (0 para salir): ");

            num = ingresarNumero();
            System.out.println("'num': " + num);
            System.out.println("num != 0: " + (num != 0));
        }
    }

    public static int ingresarNumero() {
        System.out.println("Método ingresarNumero():");
        int num = 0;
        boolean esNumeroValido = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (!esNumeroValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esNumeroValido = true;    
            } catch (Exception e) {
                System.out.println("Error: entrada incorrecta.");
                System.out.print("Ingresar número entero (0 para salir): ");
            }
        }

        System.out.println("Se retorma 'num' (" + num + ") y se desapila el método.");
        return num;
    }

    public static int sumatoria200() {
        System.out.println("Método sumatoria():");
        
        int suma = 0;
        System.out.println("'suma': " + suma);
        
        for (int i = 1; i <= MAX; i++) {
            System.out.println("'i': " + i);
            System.out.print("'suma += i': " + suma + " + " + i + ": ");
            suma += i;
            System.out.println(suma);
        }

        System.out.println("Se retorna 'suma' (" + suma + ") y se desapila el método.");
        return suma;
    }
}
