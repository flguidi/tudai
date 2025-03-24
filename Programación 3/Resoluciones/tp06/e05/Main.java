package tp06.e05;

import tp06.e05.graph.DirectedGraph;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Grafo de ciudades y puertos
        DirectedGraph<String, Integer> graph = new DirectedGraph<>();

        // Ciudades
        graph.addVertex("C1");
        graph.addVertex("C2");
        graph.addVertex("C3");
        graph.addVertex("C4");

        // Puertos
        graph.addVertex("P1");
        graph.addVertex("P2");
        graph.addVertex("P3");

        // Rutas
        graph.addEdge(0, 3, 10); // C1 -> C4
        graph.addEdge(0, 4, 50); // C1 -> P1
        graph.addEdge(1, 2, 10); // C2 -> C3
        graph.addEdge(1, 3, 20); // C2 -> C4
        graph.addEdge(2, 5, 60); // C3 -> P2
        graph.addEdge(2, 6, 50); // C3 -> P3
        graph.addEdge(3, 4, 30); // C4 -> P1
        graph.addEdge(3, 5, 20); // C4 -> P2

        CerealShippingProblem csp = new CerealShippingProblem();
        List<List<String>> shortestPaths = csp.assignPorts(graph);
        for (List<String> path : shortestPaths) {
            System.out.println(path);
        }

    }

}
