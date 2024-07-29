package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 02 --- */

/* 
Construir un programa que solicite desde teclado un número de mes y posteriormente notifique por pantalla
la cantidad de días de ese mes. En el caso de que ingrese 2 como número de mes (febrero) deberá además solicitar
ingresar un número de año, y dependiendo si es bisiesto o no con la siguiente sentencia:
    ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E02 {
    public static void main(String[] args) {
        int mes, anio;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Entrada
            System.out.print("Ingrese un número de mes (1 a 12): ");
            mes = Integer.valueOf(entrada.readLine());
        
            // Procesamiento
            switch (mes) {
                case 1, 3, 5, 7, 8, 10, 12: 
                    System.out.print("31 días");
                    break;
                case 4, 6, 9, 11:
                    System.out.print("30 días");
                    break;
                case 2:
                    System.out.print("Ingrese año: ");
                    anio = Integer.valueOf(entrada.readLine());
                    if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
                        System.out.print("29 días");
                    } else {
                        System.out.print("28 días");
                    }
                    break;
                default: 
                    System.out.println ("Ingreso inválido");            
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
