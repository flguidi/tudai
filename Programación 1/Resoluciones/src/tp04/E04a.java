package tp04;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP4 - Ejercicio 04a --- */

public class E04a {
    public static void main(String[] args) {
        int num = 5;
        int factorial = obtenerFactorial(num);
        System.out.println(num + "! = " + factorial);
    }

    public static int obtenerFactorial(int numero) {
        // Devuelve el factorial de un número dado
        int resultado = numero;
        while (numero > 1) // ("numero > 0" es incorrecto)
            resultado *= --numero;
        return resultado;
    }
}