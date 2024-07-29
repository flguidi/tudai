package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 02 --- */

/* 
Escribir un diseño de programa que mientras que el usuario ingrese un carácter dígito o carácter letra minúscula,
imprima dicho carácter, y si es carácter letra minúscula, imprima si es vocal o consonante:

DISEÑO
Declarar de variables
Obtener carácter por teclado
Mientras carácter sea dígito o letra minúscula:
    Imprimir carácter
    Si carácter es letra minúscula:
        Imprimir si es vocal o consonante
    Obtener carácter por teclado
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E02 {
    public static void main(String[] args) {
        char caracter;
        
        // Entrada
        System.out.print("Ingrese carácter: ");
        caracter = ingresarCaracter();

        // Procesamiento y salida
        while (esNumero(caracter) || esMinuscula(caracter)) {
            System.out.println("Carácter ingresado: " + caracter);
            if (esMinuscula(caracter)) {
                switch (caracter) {
                    case 'a', 'e', 'i', 'o', 'u':
                        System.out.println("Vocal");
                        break;
                    default:
                        System.out.println("Consonante");
                }
            }
            
            System.out.print("Ingrese carácter: ");
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
                System.out.println("Error. Ingresar un carácter.");
            }
        }

        return caracter;
    }

    public static boolean esNumero(char caracter) {
        return '0' <= caracter && caracter <= '9';
    }

    public static boolean esMinuscula(char caracter) {
        return 'a' <= caracter && caracter <= 'z';
    }
}
