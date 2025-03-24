package tp06.e06;

import tp06.e06.graph.UndirectedGraph;

public class Main {

    public static void main(String[] args) {
        // Grafo de ciudades y rutas
        UndirectedGraph<String, Integer> graph = new UndirectedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge(0, 1, 100);   // A - B
        graph.addEdge(0, 2, 300);   // A - C
        graph.addEdge(0, 3, 100);   // A - D
        graph.addEdge(0, 4, 75);    // A - E
        graph.addEdge(1, 2, 50);    // B - C
        graph.addEdge(1, 3, 75);    // B - D
        graph.addEdge(1, 4, 125);   // B - E
        graph.addEdge(2, 3, 100);   // C - D
        graph.addEdge(2, 4, 125);   // C - E
        graph.addEdge(3, 4, 50);    // D - E

        System.out.println(graph);

        // Solución al Problema del Viajante
        TravelingSalesmanProblem tsp = new TravelingSalesmanProblem();
        System.out.println("Problema del Viajante: " + tsp.solve(0, graph));
    }

}
