package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 10 --- */

/* 
Escribir un programa que mientras el usuario ingrese un número entero entre 1 y 10 realice:
   a. Si el numero ingresado es múltiplo de 3 pida ingresar un cáracter, y para el cáracter ingresado imprima a
      qué tipo de carácter está asociado:
          i. “letra minúscula” si el caracter es una letra del abecedario en minúscula;
          ii. “letra mayúscula” si el caracter es una letra del abecedario en mayúscula;
          iii. “dígito” si el caracter corresponde a un número;
          iv. “otro” para los restantes casos de caracteres.
   b. Si el número ingresado es múltiplo de 5 imprima la tabla de multiplicar del número ingresado.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;  

public class E10 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        int num;
        char caracter;
        String salida;
        System.out.print("Ingresar número entero entre 1 y 10: ");
        num = ingresarNumero();

        while (1 <= num && num <= 10) {
            if (num % 3 == 0) {
                System.out.print("Ingrese un carácter: ");
                caracter = ingresarCaracter();
                
                salida = evaluarCaracter(caracter);
                System.out.println(salida);
            }

            if (num % 5 == 0) {
                imprimirTablaDeMultiplicar(num);
            }

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
        String salida;
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

    public static void imprimirTablaDeMultiplicar(int num) {
        for (int i = 1; i <= MAX; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }
}
