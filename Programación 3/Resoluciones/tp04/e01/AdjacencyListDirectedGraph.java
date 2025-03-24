package tp04.e01;

import java.util.*;

/**
 * Representa un grafo dirigido utilizando una lista de adyacencia.
 * En este tipo de grafo, cada vértice mantiene una lista de aristas hacia otros vértices.
 * Esta implementación utiliza un mapa para almacenar los vértices y sus respectivas aristas.
 *
 * @param <V> El tipo de los valores de los vértices.
 * @param <E> El tipo de los pesos o etiquetas de las aristas.
 */
public class AdjacencyListDirectedGraph<V, E> implements Graph<V, E> {

    protected final Map<Integer, Vertex<V, E>> vertices;
    protected int vertexCount;

    public AdjacencyListDirectedGraph() {
        this.vertices = new HashMap<>();
        this.vertexCount = 0;
    }

    /**
     * Agrega un vértice al grafo con un valor dado.
     * Se asigna un identificador único a cada vértice al momento de ser añadido.
     * Complejidad: O(1)
     *
     * @param value El valor del nuevo vértice a agregar.
     */
    @Override
    public void addVertex(V value) {
        vertices.put(vertexCount, new Vertex<>(value));
        vertexCount++;
    }

    /**
     * Elimina un vértice del grafo y todas las aristas asociadas a él.
     * Esto incluye las aristas entrantes desde otros vértices.
     * Complejidad: O(n^2).
     *
     * @param vertexId El ID del vértice que se desea eliminar.
     */
    @Override
    public void removeVertex(Integer vertexId) {
        Vertex<V, E> vertex = vertices.remove(vertexId);
        if (vertex != null) {
            for (Vertex<V, E> v : vertices.values()) {
                if (v.containsEdge(vertexId)) {
                    v.removeEdge(vertexId);
                }
            }
            vertexCount--;
        }
    }

    /**
     * Verifica si un vértice existe en el grafo.
     * Complejidad: O(1).
     *
     * @param vertexId El ID del vértice a verificar.
     * @return {@code true} si el vértice está presente en el grafo, {@code false} en caso contrario.
     */
    @Override
    public boolean containsVertex(Integer vertexId) {
        return vertices.containsKey(vertexId);
    }

    /**
     * Obtiene el número total de vértices en el grafo.
     * Complejidad: O(1).
     *
     * @return El número de vértices en el grafo.
     */
    @Override
    public int getVertexCount() {
        return vertexCount;
    }

    /**
     * Agrega una arista dirigida entre dos vértices con un peso especificado.
     * La arista se agrega de vertexId1 a vertexId2.
     * Complejidad: O(1).
     *
     * @param vertexId1 El ID del vértice origen.
     * @param vertexId2 El ID del vértice destino.
     * @param label     El peso o etiqueta de la arista.
     */
    @Override
    public void addEdge(Integer vertexId1, Integer vertexId2, E label) {
        if (containsVertex(vertexId1) && containsVertex(vertexId2)) {
            vertices.get(vertexId1).addEdge(new Edge<>(vertexId1, vertexId2, label));
        }
    }

    /**
     * Elimina la arista dirigida entre dos vértices.
     * La arista se elimina de vertexId1 a vertexId2.
     * Complejidad: O(n).
     *
     * @param vertexId1 El ID del vértice origen.
     * @param vertexId2 El ID del vértice destino.
     */
    @Override
    public void removeEdge(Integer vertexId1, Integer vertexId2) {
        if (containsVertex(vertexId1) && containsVertex(vertexId2)) {
            vertices.get(vertexId1).removeEdge(vertexId2);
        }
    }

    /**
     * Verifica si existe una arista dirigida entre dos vértices dados.
     * Complejidad: O(n).
     *
     * @param vertexId1 El ID del vértice origen.
     * @param vertexId2 El ID del vértice destino.
     * @return {@code true} si la arista existe, {@code false} en caso contrario.
     */
    @Override
    public boolean containsEdge(Integer vertexId1, Integer vertexId2) {
        return vertices.get(vertexId1).containsEdge(vertexId2);
    }

    /**
     * Obtiene el número total de aristas en el grafo.
     * Complejidad: O(n).
     *
     * @return El número total de aristas en el grafo.
     */
    @Override
    public int getEdgeCount() {
        int edgeCount = 0;
        for (Vertex<V, E> vertex : vertices.values()) {
            edgeCount += vertex.getEdgeCount();
        }
        return edgeCount;
    }

    /**
     * Obtiene un iterador para recorrer todos los vértices del grafo.
     * Complejidad: O(1).
     *
     * @return Un iterador sobre los IDs de los vértices.
     */
    public Iterator<Integer> getVertices() {
        return vertices.keySet().iterator();
    }

    /**
     * Obtiene un vértice con el ID especificado.
     *
     * @param vertexId ID del vértice buscado.
     * @return Vértice con el ID especificado, o null si no se encontró el vértice.
     */
    public Vertex<V, E> getVertexById(Integer vertexId) {
        return vertices.get(vertexId);
    }

    /**
     * Obtiene un iterador para recorrer los vértices adyacentes a un vértice dado.
     * Complejidad: O(n).
     *
     * @param vertexId El ID del vértice del cual se desean obtener los adyacentes.
     * @return Un iterador sobre los IDs de los vértices adyacentes.
     */
    @Override
    public Iterator<Integer> getAdjacents(Integer vertexId) {
        Iterator<Integer> adjacents = Collections.emptyIterator();
        Vertex<V, E> vertex = vertices.get(vertexId);
        if (vertex != null) {
            adjacents = vertex.getAdjacents();
        }
        return adjacents;
    }

    /**
     * Obtiene un iterador para recorrer todas las aristas en el grafo.
     * Complejidad: O(n^2).
     *
     * @return Un iterador sobre todas las aristas del grafo.
     */
    @Override
    public Iterator<Edge<E>> getEdges() {
        List<Edge<E>> edges = new ArrayList<>();
        for (Vertex<V, E> vertex : vertices.values()) {
            Iterator<Edge<E>> it = vertex.getEdges();
            while (it.hasNext()) {
                edges.add(it.next());
            }
        }
        return edges.iterator();
    }

    /**
     * Obtiene un iterador para recorrer las aristas de un vértice específico.
     * Complejidad: O(n).
     *
     * @param vertexId El ID del vértice cuyas aristas se desean obtener.
     * @return Un iterador sobre las aristas del vértice dado.
     */
    @Override
    public Iterator<Edge<E>> getEdges(Integer vertexId) {
        List<Edge<E>> edges = new ArrayList<>();
        Vertex<V, E> vertex = vertices.get(vertexId);
        if (vertex != null) {
            Iterator<Edge<E>> it = vertex.getEdges();
            while (it.hasNext()) {
                edges.add(it.next());
            }
        }
        return edges.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertexCount; i++) {
            sb.append(i).append(": ").append(vertices.get(i)).append("\n");
        }
        return sb.toString();
    }

}
