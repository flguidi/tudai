package tp06.e08;

import tp06.e08.graph.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Grafo
        Graph<String, String> graph = new UndirectedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge(0, 1, null);
        graph.addEdge(0, 2, null);
        graph.addEdge(1, 2, null);
        graph.addEdge(1, 3, null);
        graph.addEdge(3, 4, null);

        System.out.println("Grafo:\n" + graph);

        // Coloreo de grafo
        GraphColoringProblem gcp = new GraphColoringProblem();
        int[] colors = gcp.solve(graph);
        System.out.println("Colores: " + Arrays.toString(colors));
    }

}
