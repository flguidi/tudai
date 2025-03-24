package tp06.e02;

import java.util.ArrayList;
import java.util.List;

/**
 * Problema de la mochila:
 * Se tienen N objetos y una mochila. Para i = 1, 2, ..., N, el objeto i tiene un peso positivo P(i) y un
 * valor positivo V(i). La mochila puede llevar un peso que no sobrepase P. El objetivo es llenar la mochila
 * de tal manera que se maximice el valor de los objetos transportados, respetando la limitación de capacidad
 * impuesta. Los objetos pueden ser fraccionados si una fracción X(i), donde 0 ≤ X(i) ≤ 1, del objeto i es
 * ubicada en la mochila contribuye en X(i)P(i) al peso total de la mochila y en X(i)V(i) al valor de la carga.
 */
public class KnapsackProblem {

    /**
     * Resuelve el problema de la mochila fraccionaria.
     *
     * @param capacity La capacidad máxima de la mochila.
     * @param elements La lista de elementos disponibles, cada uno con un valor y un peso.
     *                 Se asume que la lista no está vacía y contiene objetos válidos.
     * @return Una lista de elementos seleccionados con las fracciones correspondientes
     *         para maximizar el valor total dentro de la capacidad de la mochila.
     */
    public List<Element> solve(double capacity, List<Element> elements) {
        // Conjunto solución vacío
        List<Element> solution = new ArrayList<>();
        double totalValue = 0f;
        double remainingCapacity = capacity;

        // Se ordenan los elementos por valor/peso decreciente
        elements.sort(new Element.ValuePerWeightComparator().reversed());

        // Mientras puedan seguir agregándose elementos
        while (remainingCapacity > 0 && !elements.isEmpty()) {
            Element e = elements.removeFirst();

            if (e.getWeight() <= remainingCapacity) {
                // Elemento entero
                e.setFraction(1);
                totalValue += e.getValue();
                remainingCapacity -= e.getWeight();
            } else {
                // Elemento fraccionado
                e.setFraction(remainingCapacity / e.getWeight());
                totalValue += e.getValue() * e.getFraction();
                remainingCapacity = 0;
            }

            solution.add(e);
        }

        System.out.printf("Valor total: %.1f\n", totalValue);
        return solution;
    }

}
