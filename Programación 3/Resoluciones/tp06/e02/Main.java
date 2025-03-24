package tp06.e02;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Elementos
        List<Element> elements = new ArrayList<>();
        elements.add(new Element("Cuaderno", 1.2f, 100));
        elements.add(new Element("Cartuchera", 0.5f, 120));
        elements.add(new Element("Carpeta", 1.5f, 120));

        System.out.println("Elementos:");
        for (Element element : elements) {
            System.out.println(element);
        }

        // Problema de la mochila fraccionaria
        KnapsackProblem kp = new KnapsackProblem();
        System.out.println("\nSolución:");
        for (Element element : kp.solve(2f, elements)) {
            System.out.println(element);
        }
    }

}
