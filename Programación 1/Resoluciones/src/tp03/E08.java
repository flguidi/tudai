package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 08 --- */

/*
Realizar un programa que dado dos números enteros y un carácter, todos ingresados por el usuario, muestre por
pantalla el resultado de la operación matemática básica considerando el valor del carácter: 'a' para la suma, ‘b’
para la resta, ‘c’ para la multiplicación y ‘d’ para la división.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E08 {
    public static void main(String[] args) {
        char opcion = ' ';
        float num1, num2;

        System.out.print("Ingrese el primer número: ");
        num1 = ingresarNumero();
        System.out.print("Ingrese el segundo número: ");
        num2 = ingresarNumero();
        System.out.println("Ingrese una opción:\na. Suma\nb. Resta\nc. Multiplicación\nd. División");
        opcion = ingresarOpcion();

        imprimirResultado(num1, num2, opcion);
    }

    public static float ingresarNumero() {
        float num = 0;
        boolean esNumero = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (!esNumero) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esNumero = true;
            } catch (Exception e) {
                System.out.println("Error: no se ingresó un número.");
                System.out.print("Volver a intentar: ");
            }
        }

        return num;
    }

    public static char ingresarOpcion() {
        char opcion = ' ';
        boolean caracterValido = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        while (!caracterValido) {
            try {
                opcion = entrada.readLine().charAt(0);
                caracterValido = true;
            } catch (Exception e) {
                System.out.println("Error: no se ingresó un número.");
                System.out.print("Volver a intentar: ");
            }
        }

        return opcion;
    }

    public static void imprimirResultado(float num1, float num2, char opcion) {
        switch (opcion) {
            case 'a': 
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); 
                break;
            case 'b': 
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2)); 
                break;
            case 'c': 
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2)); 
                break;
            case 'd': 
                if (num2 == 0) {
                    System.out.println("Error: no se puede dividir por 0.");
                } else {
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                }    
                break;
            default: System.out.println("Error");
        }
    }
}
