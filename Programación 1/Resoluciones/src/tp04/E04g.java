package tp04;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP4 - Ejercicio 04g --- */

public class E04g {
    public static void main(String[] args) {
        int num1 = 12, num2 = 6;
        int mcd = maximoComunDivisor(num1, num2);
        System.out.println("MCD entre " + num1 + " y " + num2 + ": " + mcd);
    }

    public static int maximoComunDivisor(int num1, int num2) {
        // Determina el MCD de dos número enteros
        int mcd = 1;
        int divisor = 2;
        
        while (divisor <= num1 && divisor <= num2) {
            if (num1 % divisor == 0 && num2 % divisor == 0) {
                mcd = divisor;
            }
            divisor++;
        }

        return mcd;
    }
}
