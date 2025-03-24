package tp05.e01;

import tp05.e01.graph.DirectedGraph;

public class Main {

    public static void main(String[] args) {
        // Grafo
        DirectedGraph<String, String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge(0, 1, null);
        graph.addEdge(0, 5, null);
        graph.addEdge(1, 2, null);
        graph.addEdge(1, 3, null);
        graph.addEdge(2, 4, null);
        graph.addEdge(3, 5, null);
        graph.addEdge(4, 3, null);

        System.out.println("Grafo:");
        System.out.println(graph);

        // Resolución al problema de las salas
        RoomProblem rp = new RoomProblem();
        int entry = 0;
        int exit = 5;
        System.out.println("Camino más largo entre " + entry + " y " + exit + ": " + rp.findLongestPath(entry, exit, graph));
    }

}
