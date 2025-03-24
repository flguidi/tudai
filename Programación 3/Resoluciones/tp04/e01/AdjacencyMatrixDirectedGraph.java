package tp04.e01;

import java.util.*;

/**
 * Representa un grafo dirigido utilizando un mapa de vértices y una matriz de adyacencia.
 *
 * @param <V> El tipo de los valores de los vértices.
 * @param <E> El tipo de los pesos o etiquetas de las aristas.
 */
@SuppressWarnings("unchecked")
public class AdjacencyMatrixDirectedGraph<V, E> implements Graph<V, E> {

    protected final Map<Integer, V> vertices;
    protected E[][] adjacencyMatrix;
    protected Integer vertexCount;

    public AdjacencyMatrixDirectedGraph() {
        vertices = new HashMap<>();
        adjacencyMatrix = (E[][]) new Object[0][0];
        vertexCount = 0;
    }

    /**
     * Agrega un vértice al grafo.
     * Complejidad: O(n^2).
     *
     * @param value El valor del vértice a agregar.
     */
    @Override
    public void addVertex(V value) {
        // Se agrega el vértice al hashmap
        vertices.put(vertexCount, value);
        vertexCount++;

        // Se crea una nueva matriz de adyacencia con un tamaño mayor
        E[][] newMatrix = (E[][]) new Object[vertexCount][vertexCount];

        // Se copian los valores de la matriz original a la nueva matriz
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                newMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }

        // Se actualiza la referencia de la matriz de adyacencia
        adjacencyMatrix = newMatrix;
    }

    /**
     * Elimina un vértice del grafo, aunque este tipo de grafo no admite eliminación por ID.
     *
     * @param vertexId El ID del vértice a eliminar.
     */
    @Override
    public void removeVertex(Integer vertexId) {
        // Este tipo de grafo no admite la eliminación de vértices por ID.
        System.out.println("Este tipo de grafo no admite eliminación de vértices por ID. Utilizar método removeLastVertex().");
    }

    /**
     * Elimina el último vértice agregado al grafo, copiando el contenido de la matriz de adyacencia en una de menor tamaño.
     * Complejidad: O(n^2).
     */
    public void removeLastVertex() {
        if (vertices.isEmpty()) {
            return;
        }

        // Se elimina el último vértice agregado
        vertices.remove(vertexCount - 1);
        vertexCount--;

        // Se crea una nueva matriz de adyacencia con un tamaño menor
        E[][] newMatrix = (E[][]) new Object[vertexCount][vertexCount];

        // Se copian los valores de la matriz original a la nueva matriz
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                newMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }

        // Se actualiza la referencia de la matriz de adyacencia
        adjacencyMatrix = newMatrix;
    }

    /**
     * Verifica si el grafo contiene un vértice con el ID proporcionado.
     * Complejidad: O(1).
     *
     * @param vertexId El ID del vértice a verificar.
     * @return {@code true} si el vértice existe, {@code false} si no.
     */
    @Override
    public boolean containsVertex(Integer vertexId) {
        return vertices.containsKey(vertexId);
    }

    /**
     * Obtiene la cantidad de vértices en el grafo.
     * Complejidad: O(1).
     *
     * @return El número de vértices en el grafo.
     */
    @Override
    public int getVertexCount() {
        return vertexCount;
    }

    /**
     * Agrega una arista entre dos vértices con un peso o etiqueta dada.
     * Complejidad: O(1).
     *
     * @param vertexId1 El ID del primer vértice (origen).
     * @param vertexId2 El ID del segundo vértice (destino).
     * @param label     El peso o etiqueta de la arista.
     */
    @Override
    public void addEdge(Integer vertexId1, Integer vertexId2, E label) {
        if (containsVertex(vertexId1) && containsVertex(vertexId2)) {
            adjacencyMatrix[vertexId1][vertexId2] = label;
        }
    }

    /**
     * Elimina una arista entre dos vértices.
     * Complejidad: O(1).
     *
     * @param vertexId1 El ID del primer vértice (origen).
     * @param vertexId2 El ID del segundo vértice (destino).
     */
    @Override
    public void removeEdge(Integer vertexId1, Integer vertexId2) {
        if (vertices.containsKey(vertexId1) && vertices.containsKey(vertexId2)) {
            adjacencyMatrix[vertexId1][vertexId2] = null;
        }
    }

    /**
     * Verifica si existe una arista entre dos vértices.
     * Complejidad: O(1).
     *
     * @param vertexId1 El ID del primer vértice (origen).
     * @param vertexId2 El ID del segundo vértice (destino).
     * @return {@code true} si existe la arista, {@code false} si no.
     */
    @Override
    public boolean containsEdge(Integer vertexId1, Integer vertexId2) {
        if (vertices.containsKey(vertexId1) && vertices.containsKey(vertexId2)) {
            return adjacencyMatrix[vertexId1][vertexId2] != null;
        }
        return false;
    }

    /**
     * Obtiene el número de aristas en el grafo.
     * Complejidad: O(n^2).
     *
     * @return La cantidad de aristas en el grafo.
     */
    @Override
    public int getEdgeCount() {
        int edgeCount = 0;
        for (E[] sourceVertex : adjacencyMatrix) {
            for (E edge : sourceVertex) {
                if (edge != null) {
                    edgeCount++;
                }
            }
        }
        return edgeCount;
    }

    /**
     * Obtiene un iterador de los IDs de los vértices en el grafo.
     * Complejidad: O(1).
     *
     * @return Un iterador sobre los IDs de los vértices.
     */
    @Override
    public Iterator<Integer> getVertices() {
        return vertices.keySet().iterator();
    }

    /**
     * Obtiene un iterador de los vértices adyacentes a un vértice dado.
     * Complejidad: O(n).
     *
     * @param vertexId El ID del vértice de origen.
     * @return Un iterador de los vértices adyacentes.
     */
    @Override
    public Iterator<Integer> getAdjacents(Integer vertexId) {
        // Lista para almacenar los vértices adyacentes
        List<Integer> adjacents = new ArrayList<>();

        // Se verifica si existe el vértice
        if (vertices.containsKey(vertexId)) {
            // Se recorre la fila correspondiente en la matriz de adyacencia
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[vertexId][j] != null) {
                    adjacents.add(j);
                }
            }
        }

        return adjacents.iterator();
    }

    /**
     * Obtiene un iterador de todas las aristas del grafo.
     * Complejidad: O(n^2).
     *
     * @return Un iterador de todas las aristas en el grafo.
     */
    @Override
    public Iterator<Edge<E>> getEdges() {
        List<Edge<E>> edges = new ArrayList<>(); // Lista para almacenar las aristas

        // Se recorre la matriz de adyacencia
        for (int i = 0; i < adjacencyMatrix.length; i++) { // Filas
            for (int j = 0; j < adjacencyMatrix[i].length; j++) { // Columnas
                if (adjacencyMatrix[i][j] != null) {
                    // Si existe la arista en la posición (i, j), se crea una nueva y se agrega a la lista
                    edges.add(new Edge<>(i, j, adjacencyMatrix[i][j]));
                }
            }
        }

        return edges.iterator();
    }

    /**
     * Obtiene un iterador de todas las aristas salientes de un vértice dado.
     * Complejidad: O(n).
     *
     * @param vertexId El ID del vértice de origen.
     * @return Un iterador de las aristas salientes del vértice dado.
     */
    @Override
    public Iterator<Edge<E>> getEdges(Integer vertexId) {
        List<Edge<E>> edges = new ArrayList<>(); // Lista para almacenar las aristas

        // Se recorre la fila del vértice
        for (int j = 0; j < adjacencyMatrix.length; j++) { // Columnas
            if (adjacencyMatrix[vertexId][j] != null) {
                // Si existe la arista en la posición (i, j), se crea una nueva y se agrega a la lista
                edges.add(new Edge<>(vertexId, j, adjacencyMatrix[vertexId][j]));
            }
        }

        return edges.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Encabezado con los identificadores de las columnas (vértices de destino)
        sb.append("\t");
        for (Integer v : vertices.keySet()) {
            sb.append(v).append("\t");  // ID de cada vértice de destino
        }
        sb.append("\n");

        // Filas
        Iterator<Integer> it = this.getVertices();
        for (int i = 0; i < adjacencyMatrix.length && it.hasNext(); i++) {
            // ID del vértice de origen (fila)
            sb.append(it.next()).append("\t");

            // Aristas
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] == null) {
                    sb.append("-"); // Arista vacía
                } else {
                    sb.append(adjacencyMatrix[i][j]); // Etiqueta de arista
                }
                sb.append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
