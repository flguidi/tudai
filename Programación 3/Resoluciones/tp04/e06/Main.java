package tp04.e06;

import tp04.e01.AdjacencyListUndirectedGraph;
import tp04.e01.Graph;

public class Main {

    public static void main(String[] args) {
        // Grafo (ciudad)
        Graph<String, String> city = new AdjacencyListUndirectedGraph<>();
        int n = 4; // Cantidad de esquinas por lado (Ciudad = n^2)

        // Vértices (esquinas)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city.addVertex("(" + i + "," + j + ")");
            }
        }

        // Aristas (calles) horizontales
        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((id + 1) % n != 0) {
                    city.addEdge(id, id + 1, "[(" + i + "," + j + ")-(" + i + "," + (j + 1) + ")]");
                }
                id++;
            }
        }

        // Aristas (calles) verticales
        for (int j = 0; j < n; j++) {
            id = j;
            for (int i = 0; i < n - 1; i++) {
                city.addEdge(id, id + n, "[(" + i + "," + j + ")-(" + (i + 1) + "," + j + ")]");
                id += n;
            }
        }

        System.out.println(city);

        // Camino más corto entre dos esquinas
        BFSPathFinder<String, String> pf = new BFSPathFinder<>();
        int start = 0;
        int end = 15;

        System.out.print("Camino más corto entre las esquinas " + start + " y " + end + ": ");
        System.out.println(pf.shortestPath(start, end, city));
    }

}
