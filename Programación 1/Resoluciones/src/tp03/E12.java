package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 12 --- */

/*
Escribir un programa que simule 1000 lanzamientos de un dado y muestre por pantalla cuántas veces salió el
valor del dado correspondiente al número entero N ingresado por el usuario. Considerar que el valor N ingresado
se corresponda a un valor posible para un dado. Usar la sentencia Math.random() que devuelve un valor aleatorio
real entre 0 y 1.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E12 {
    public static final int TIRADAS = 1000;

    public static void main(String[] args) {
        int num, contador;
        System.out.print("Ingresar número entero entre 1 y 6: ");
        num = ingresarEntero();

        if (1 <= num && num <= 6) {
            contador = tirarDados(TIRADAS, num);
            System.out.print("Cantidad de veces que salió el " + num + ": " + contador);
        }
    }

    public static int ingresarEntero() {
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

    public static int tirarDados(int tiradas, int numeroUsuario) {
        int dado, contador = 0;
        for (int i = 0; i < tiradas; i++) {
            dado = (int) (6 * Math.random() + 1);
            if (dado == numeroUsuario) {
                contador++;
            }
        }

        return contador;
    }
}
