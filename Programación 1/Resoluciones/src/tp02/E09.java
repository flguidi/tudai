package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 09 --- */

/*
Escribir un programa que mientras que el usuario ingrese un carácter dígito o carácter letra minúscula,
imprima si es carácter dígito o carácter letra minúscula, y si es letra minúscula imprimir si es vocal o
consonante.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E09 {
    public static void main(String[] args) {
        // Declaración de variables y objetos
        char c;
        boolean esCaracterValido = true;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("DEBUGGING PARA PRÁCTICA 04, EJERCICIO 02"); 
        System.out.println("'esCaracterValido': " + esCaracterValido);

        while (esCaracterValido) {
            try {
                // Entrada
                System.out.print("Ingrese un carácter alfanumérico: ");
                c = entrada.readLine().charAt(0);
                System.out.println("c: '" + c + "'");

                // Procesamiento y salida
                System.out.println("c >= 'a' && c <= 'z': " + (c >= 'a' && c <= 'z'));
                System.out.println("c >= '0' && c <= '9': " + (c >= '0' && c <= '9'));
                System.out.println("(c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'): " +
                        (c >= 'a' && c <= 'z' || c >= '0' && c <= '9'));

                if (c >= 'a' && c <= 'z') {
                    System.out.print("Letra minúscula ");
                    switch (c) {
                        case 'a', 'e', 'i', 'o', 'u': 
                            System.out.println("vocal");
                            break;
                        default: System.out.println("consonante");
                    }
                } else if (c >= '0' && c <= '9') {
                    System.out.println("Número");
                } else {
                    System.out.println("¡No es un carácter alfanumérico!");                    
                    esCaracterValido = false;
                }
                System.out.println("'esCaracterValido': " + esCaracterValido);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
