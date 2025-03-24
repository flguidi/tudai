package tp06.e08;

import tp06.e08.graph.Graph;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Coloreo de un grafo:
 * Dado un grafo se desea colorear cada uno de sus vértices utilizando la menor cantidad posible
 * de colores totales, sabiendo que dos vértices adyacentes no podrán utilizar el mismo color.
 */
public class GraphColoringProblem {

    public int[] solve(Graph<?, ?> graph) {
        // Arreglo de colores asignados a cada vértice
        int[] colors = new int[graph.getVertexCount()];

        // Se inicializa el arreglo con -1 (sin color)
        Arrays.fill(colors, -1);

        // Arreglo de colores disponibles
        boolean[] available = new boolean[graph.getVertexCount()];

        // Se colorean uno por uno los vértices
        Iterator<Integer> vertices = graph.getVertices();
        while (vertices.hasNext()) {
            int vertex = vertices.next();
            Arrays.fill(available, true);

            // Marca los colores de los vértices adyacentes como no disponibles
            Iterator<Integer> adjacents = graph.getAdjacents(vertex);
            while (adjacents.hasNext()) {
                int adjacent = adjacents.next();
                if (colors[adjacent] != -1) {
                    available[colors[adjacent]] = false;
                }
            }

            // Se asigna el primer color disponible
            int color;
            for (color = 0; color < colors.length; color++) {
                if (available[color]) {
                    break;
                }
            }

            colors[vertex] = color; // Se asigna el color encontrado
        }

        return colors;
    }

}
