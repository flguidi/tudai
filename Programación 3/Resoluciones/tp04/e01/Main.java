package tp04.e01;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // Grafo (elegir tipo)
        Graph<String, String> g = new AdjacencyMatrixUndirectedGraph<>();

        // Creación de vértices
        System.out.println("Creación de vértices:");
        g.addVertex("V0");
        g.addVertex("V1");
        g.addVertex("V2");
        g.addVertex("V3");
        g.addVertex("V4");

        // Creación de aristas
        g.addEdge(0, 1, "0-1");
        g.addEdge(1, 2, "1-2");
        g.addEdge(1, 3, "1-3");
        g.addEdge(1, 4, "1-4");
        g.addEdge(2, 4, "2-4");

        System.out.println(g);

        // Eliminación de vértices y aristas
        System.out.println("Eliminación de vértices y aristas:");
        g.removeVertex(4);
        g.removeEdge(2, 4);

        System.out.println(g);

        // Cantidad de vértices y aristas
        System.out.println("Cantidad de vértices: " + g.getVertexCount());
        System.out.println("Cantidad de aristas: " + g.getEdgeCount());

        // Vértices
        System.out.print("Vértices del grafo: ");
        Iterator<?> it = g.getVertices();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // Vértices adyacentes
        int v = 0;
        System.out.print("\nAdyacentes del vértice " + v + ": ");
        it = g.getAdjacents(v);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // Aristas
        System.out.print("\nAristas del grafo: ");
        it = g.getEdges();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.print("\nAristas de salida del vértice " + v + ": ");
        it = g.getEdges(v);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        int v1 = 2;
        int v2 = 3;
        System.out.println("\n¿Existe una arista entre los vértices " + v1 + " y " + v2 + "?: " + g.containsEdge(v1, v2));
    }

}
