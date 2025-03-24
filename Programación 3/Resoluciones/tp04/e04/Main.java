package tp04.e04;

import tp04.e01.AdjacencyMatrixDirectedGraph;
import tp04.e01.Graph;

public class Main {

    public static void main(String[] args) {
        // Grafo
        Graph<String, String> g = new AdjacencyMatrixDirectedGraph<>();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");

        g.addEdge(0, 1, "A-B");
        g.addEdge(0, 2, "A-C");
        g.addEdge(1, 2, "B-C");
        g.addEdge(2, 3, "C-D");
        g.addEdge(2, 4, "C-E");
        g.addEdge(3, 4, "D-E");

        // Búsqueda de caminos entre dos vértices
        DFSPathFinder<String, String> pf = new DFSPathFinder<>();
        int start = 0;
        int end = 4;

        // Camino más corto
        System.out.print("Camino más corto entre los vértices " + start + " y " + end + ": ");
        System.out.println(pf.shortestPath(start, end, g));

        // Camino más largo
        System.out.print("Camino más largo entre los vértices " + start + " y " + end + ": ");
        System.out.println(pf.longestPath(start, end, g));
    }

}
