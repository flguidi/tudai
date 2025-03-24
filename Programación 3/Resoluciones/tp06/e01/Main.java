package tp06.e01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Denominaciones y monto
        Integer[] denominations = {1, 5, 10, 25, 100};
        int amount = 289;

        System.out.println("Denominaciones: " + Arrays.toString(denominations));
        System.out.println("Monto: $" + amount);

        // Resolución greedy del problema de Cambio de Moneda
        CoinChangeProblem ccp = new CoinChangeProblem();
        int[] coinCount = ccp.solve(denominations, amount);

        for (int i = 0; i < denominations.length; i++) {
            System.out.println("Cantidad de billetes de $" + denominations[i] + ": " + coinCount[i]);
        }
    }

}
