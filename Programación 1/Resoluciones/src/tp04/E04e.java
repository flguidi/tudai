package tp04;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP4 - Ejercicio 04e --- */

public class E04e {
    public static void main(String[] args) {
        int num = 1560;
        int cantDigitos = contarDigitos(num);
        System.out.println("Cantidad de dígitos de " + num + ": " + cantDigitos);
    }

    public static int contarDigitos(int n) {
        // Cuenta dígitos de un número dado
        int contador = 0;
        while (n != 0) {
            n /= 10;
            contador++;
        }
        return contador;
    }
}
