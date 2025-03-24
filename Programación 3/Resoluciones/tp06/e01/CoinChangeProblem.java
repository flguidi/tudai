package tp06.e01;

import java.util.Arrays;
import java.util.Collections;

/**
 * Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de ejemplares de
 * cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo número de ellas.
 * Por ejemplo, un cajero automático dispone de billetes de distintos valores: $100, $25, $10, $5 y $1,
 * si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de $100, 3 de $25, 1 de
 * $10 y 4 de $1.
 */
public class CoinChangeProblem {

    /**
     * Encuentra una solución al problema de cambio de monedas utilizando un enfoque voraz.
     *
     * @param denominations Un arreglo de enteros que representa las denominaciones de las monedas disponibles.
     * @param amount        El monto total a alcanzar.
     * @return Un arreglo de enteros donde cada posición representa la cantidad de monedas utilizadas de cada
     *         denominación en el mismo orden que el arreglo de entrada.
     */
    public int[] solve(Integer[] denominations, int amount) {
        // Se crea una solución vacía
        int[] coinCount = new int[denominations.length];

        // Se ordenan descendentemente las denominaciones
        Arrays.sort(denominations, Collections.reverseOrder());

        for (int i = 0; i < denominations.length; i++) {
            int count = 0;

            while (amount >= denominations[i]) {
                amount -= denominations[i];
                count++;
            }

            coinCount[i] = count;
        }

        return coinCount;
    }

}
