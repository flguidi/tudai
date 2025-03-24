package tp04.e05;

import tp04.e01.AdjacencyListDirectedGraph;
import tp04.e01.Graph;

public class Main {

    public static void main(String[] args) {
        // Grafo
        Graph<String, String> g = new AdjacencyListDirectedGraph<>();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");

        g.addEdge(0, 1, "A-B");
        g.addEdge(0, 2, "A-C");
        g.addEdge(2, 1, "C-B");
        g.addEdge(2, 3, "C-D");
        g.addEdge(2, 4, "C-E");
        g.addEdge(3, 4, "D-E");

        // Vértices a partir de los cuales existe un camino hasta un vértice destino dado
        DFSReversePathFinder<String, String> rpf = new DFSReversePathFinder<>();
        int target = 4;

        System.out.print("Vértices que poseen un camino hasta el vértice " + target + ": ");
        System.out.println(rpf.getVerticesToTarget(target, g));
    }

}
