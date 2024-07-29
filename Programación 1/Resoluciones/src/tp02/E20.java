package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 20 --- */

/* 
Pedir números enteros positivos por teclado. En cada iteración el usuario puede ingresar 0 para salir del programa.
Si ingresa un número distinto de 0 se debe pedir el ingreso de un carácter:
    a. Si es ‘a’ se debe permitir al usuario escribir un texto libre e imprimirlo por pantalla.
    b. Si es ‘b’ se deben pedir 5 números positivos e informar si fueron ingresados en orden ascendente.
    c. Si es ‘c’ se deben pedir dos números enteros negativos e imprimir la raíz cuadrada de su multiplicación. La
       raíz cuadrada de un número se calcula con la sentencia: Math.sqrt(numero).
    d. Ante cualquier otro carácter ingresado se debe informar un error y pedir nuevamente el carácter. 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E20 {
    public static void main(String[] args) {
        int num, n1, n2, n3, n4, n5;
        char opcion;
        String texto;
        float resultado;
        boolean caracterValido = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Ingrese un número (0 para salir): ");
            num = Integer.valueOf(entrada.readLine());

            while (num != 0) {
                while (!caracterValido) {
                    System.out.print("Ingrese una opción (a | b | c): ");
                    opcion = entrada.readLine().charAt(0);
                    
                    switch(opcion) {
                        case 'a':
                            System.out.println("Escriba un texto: ");
                            texto = entrada.readLine();
                            System.out.println("Texto ingresado: " + texto);
                            caracterValido = true;
                            break;

                        case 'b':
                            System.out.println("Ingrese 5 números enteros positivos: ");
                            n1 = Integer.valueOf(entrada.readLine());
                            n2 = Integer.valueOf(entrada.readLine());
                            n3 = Integer.valueOf(entrada.readLine());
                            n4 = Integer.valueOf(entrada.readLine());
                            n5 = Integer.valueOf(entrada.readLine());
                            if (n1 < n2 && n2 < n3 && n3 < n4 && n4 < n5) {
                                System.out.println("Ascendente");
                            } else if (n1 > n2 && n2 > n3 && n3 > n4 && n4 > n5) {
                                System.out.println("Descendente");
                            }
                            caracterValido = true;
                            break;

                        case 'c':
                            System.out.println("Ingrese 2 números enteros negativos: ");
                            n1 = Integer.valueOf(entrada.readLine());
                            n2 = Integer.valueOf(entrada.readLine());
                            if (n1 < 0 && n2 < 0) {
                                resultado = (float) Math.sqrt(n1 * n2);
                                System.out.println("La raiz cuadrada de " + (n1 * n2) + " es: " + resultado);
                            }
                            caracterValido = true;
                            break;
                            
                        default: 
                            System.out.println("Error");
                    }
                }

                System.out.print("Ingrese un número (0 para salir): ");
                num = Integer.valueOf(entrada.readLine());
                caracterValido = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
