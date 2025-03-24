package tp04.e03;

import tp04.e01.AdjacencyMatrixDirectedGraph;
import tp04.e01.Graph;

public class Main {

    public static void main(String[] args) {
        Graph<String, String> g = new AdjacencyMatrixDirectedGraph<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");

        g.addEdge(0, 1, "A-B");
        g.addEdge(0, 2, "C-A");
        g.addEdge(1, 2, "B-C");
        g.addEdge(2, 3, "C-D");
        g.addEdge(2, 4, "C-E");
        g.addEdge(3, 1, "D-A");

        GraphCycleChecker<String, String> gcc = new GraphCycleChecker<>();
        System.out.println("¿El grafo es cícliclo?: " + gcc.hasCycle(g));
    }

}
