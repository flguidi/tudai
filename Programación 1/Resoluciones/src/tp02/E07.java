package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 07 --- */

/*
Escribir un programa que mientras el usuario ingresa un caracter distinto del carácter ‘*’, muestre por
pantalla si es carácter dígito, o si es carácter vocal minúscula.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E07 {
    public static void main(String[] args) {
        char caracter = 'a';
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (caracter != '*') {
            try {
                System.out.print("Ingrese un carácter ('*') para salir): ");
                caracter = entrada.readLine().charAt(0);

                if (caracter != '*') {
                    if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                        System.out.println("Vocal minúscula");
                    } else if ('0' <= caracter && caracter <= '9'){
                        System.out.println("Número");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
