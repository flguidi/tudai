package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 09 --- */

/* 
Escribir un programa que mientras el usuario ingrese un número entero entre 1 y 10, pida ingresar un carácter, y
por cada carácter ingresado imprima:
    a. “letra minúscula” si el carácter es una letra del abecedario en minúscula;
    b. “letra mayúscula” si el carácter es una letra del abecedario en mayúscula;
    c. “dígito” si el caracter corresponde a un número;
    d. “otro” para los restantes casos de caracteres. 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;    

public class E09 {
    public static void main(String[] args) {
        int num;
        char caracter;
        String salida;
        System.out.print("Ingresar número entero entre 1 y 10: ");
        num = ingresarNumero();

        while (1 <= num && num <= 10) {
            System.out.print("Ingrese un carácter: ");
            caracter = ingresarCaracter();
            
            salida = evaluarCaracter(caracter);
            System.out.println(salida);
            
            System.out.print("Ingresar número entero entre 1 y 10: ");
            num = ingresarNumero();
        }
    }

    public static int ingresarNumero() {
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

    public static String evaluarCaracter(char caracter) {
        String salida = "";
        if ('a' <= caracter && caracter <= 'z') {
            salida = "Letra minúscula";
        } else if ('A' <= caracter && caracter <= 'Z') {
            salida = "Letra mayúscula";
        } else if ('0' <= caracter && caracter <= '9') {
            salida = "Dígito";
        } else {
            salida = "Otro";
        }
        
        return salida;
    }
}
