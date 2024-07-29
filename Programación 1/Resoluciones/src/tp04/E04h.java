package tp04;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP4 - Ejercicio 04h --- */

public class E04h {
    public static void main(String[] args) {
        int numDecimal = 8;
        String numBinario = decimalABinario(numDecimal);
        System.out.println(numDecimal + " en binario es " + numBinario);
    }

    public static String decimalABinario(int num) {
        // Convierte un número decimal a su representación binaria
        String binario = "";
        while (num > 0) {
            int resto = num % 2;
            binario = resto + binario;
            num /= 2;
        }
        return binario;
    }
}
