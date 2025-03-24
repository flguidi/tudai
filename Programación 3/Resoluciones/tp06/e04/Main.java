package tp06.e04;

import tp06.e04.graph.DirectedGraph;

public class Main {

    public static void main(String[] args) {
        // Grafo dirigido ponderado
        DirectedGraph<String, Integer> graph = new DirectedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 3, 30);
        graph.addEdge(0, 4, 100);
        graph.addEdge(1, 2, 50);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 2, 20);
        graph.addEdge(3, 4, 60);

        System.out.println("Grafo:\n" + graph);

        // Dijkstra
        int start = 0;
        Dijkstra<String> dijkstra = new Dijkstra<>();
        dijkstra.findShortestPaths(graph, start);
    }

}
