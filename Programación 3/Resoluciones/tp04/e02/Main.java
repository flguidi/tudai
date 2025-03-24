package tp04.e02;

import tp04.e01.*;

public class Main {

    public static void main(String[] args) {
        // Grafo
        Graph<String, String> g = new AdjacencyMatrixDirectedGraph<>();

        g.addVertex("0");
        g.addVertex("1");
        g.addVertex("2");
        g.addVertex("3");
        g.addVertex("4");

        g.addEdge(0, 2, "0-2");
        g.addEdge(0, 3, "0-3");
        g.addEdge(1, 3, "1-3");
        g.addEdge(2, 3, "2-3");
        g.addEdge(3, 4, "3-4");

        System.out.println("Grafo:");
        System.out.println(g);

        // ----------------------- Recorrido en profundidad (DFS) ----------------------- //
        System.out.println("---------------------- DFS ----------------------");
        DFS<String, String> dfs = new DFS<>();

        // DFS recursivo sobre todos los vértices
        System.out.println("DFS recursivo sobre todos los vértices: ");
        System.out.print(dfs.recursiveTraversal(g));

        // DFS recursivo comenzando en un vértice específico
        int start = 0;
        System.out.println("\nDFS recursivo comenzando en el vértice " + start + ":");
        System.out.println(dfs.recursiveTraversal(g, start));

        // DFS iterativo sobre todos los vértices
        System.out.println("DFS iterativo sobre todos los vértices: ");
        System.out.println(dfs.iterativeTraversal(g));

        // DFS iterativo comenzando en un vértice específico
        System.out.println("DFS iterativo comenzando en el vértice " + start + ":");
        System.out.println(dfs.iterativeTraversal(g, start));

        // ----------------------- Recorrido en amplitud (BFS) ----------------------- //
        System.out.println("\n---------------------- BFS ----------------------");
        BFS<String, String> bfs = new BFS<>();

        // BFS sobre todos los vértices
        System.out.println("BFS sobre todos los vértices: ");
        System.out.println(bfs.traverse(g));

        // BFS sobre un vértice de inicio
        System.out.println("BFS comenzando en el vértice " + start + ":");
        System.out.println(bfs.traverse(g, start));
    }

}
