package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 13 --- */

/*
Escribir un programa que mientras que el usuario ingrese un caracter letra minúscula, pida ingresar un número
entero. Si el número ingresado está entre 1 y 5 inclusive deberá imprimir latabla de multiplicar de dicho número.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E13 {
    public static void main(String[] args) {
        final int MAX = 10;
        char caracter;
        int num, resultado;
        boolean caracterValido = true;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        while (caracterValido) {
            try {
                // Ingreso de letra
                System.out.print("Ingrese una letra minúscula: ");
                caracter = entrada.readLine().charAt(0);

                // Verificación de caracter
                if (caracter >= 'a' && caracter <= 'z') {
                    // Ingreso de número
                    System.out.print("Ingrese un número entero: ");
                    num = Integer.valueOf(entrada.readLine());
                    
                    // Tabla de multiplicar
                    if (num >= 1 && num <= 5) {
                        for (int multiplicador = 1; multiplicador <= MAX; multiplicador++) {
                            resultado = num * multiplicador;
                            System.out.println(num + " * " + multiplicador + " = " + resultado);
                        }
                    }
                } else {
                    caracterValido = false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
