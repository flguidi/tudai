package tp04;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP4 - Ejercicio 04c --- */

public class E04c {
    public static void main(String[] args) {
        int num = 7;
        boolean esPrimo = esPrimo(num);
        System.out.println("¿El número " + num + " es primo? " + esPrimo);
    }

    public static boolean esPrimo(int numero) {
        // Devuelve si es o no primo un número dado
        int divisor = 2;
        if (numero < 2)
            return false;
        while (divisor < numero && numero % divisor != 0) {
            divisor++;
        }
        return (numero == divisor);
    }
}
