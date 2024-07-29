package tp04;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP4 - Ejercicio 04d --- */

public class E04d {
    public static void main(String[] args) {
        int a = 3, b = 4, c = 1;
        int mayor = buscarMayor(a, b, c);
        System.out.println("El mayor es: " + mayor);
    }

    public static int buscarMayor(int a, int b, int c) {
        // Retorna el mayor de 3 números
        int mayor = a;
        if (b > mayor) {
            mayor = b;
        }
        if (c > mayor) {
            mayor = c;
        }
        return mayor;
    }
}
