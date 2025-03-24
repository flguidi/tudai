package tp05.e01.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex<V, E> {

    private V value;
    private final List<Edge<E>> edges;

    public Vertex(V value) {
        this.value = value;
        this.edges = new ArrayList<>();
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Iterator<Integer> getAdjacents() {
        List<Integer> adjacents = new ArrayList<>();
        for (Edge<E> edge : edges) {
            adjacents.add(edge.getTargetVertexId());
        }
        return adjacents.iterator();
    }

    public void addEdge(Edge<E> edge) {
        edges.add(edge);
    }

    public void removeEdge(Integer targetVertexId) {
        Iterator<Edge<E>> it = edges.iterator();
        while (it.hasNext()) {
            Edge<E> edge = it.next();
            if (edge.getTargetVertexId().equals(targetVertexId)) {
                it.remove();
                break;
            }
        }
    }

    public boolean containsEdge(Integer targetVertexId) {
        for (Edge<E> edge : edges) {
            if (edge.getTargetVertexId().equals(targetVertexId)) {
                return true;
            }
        }
        return false;
    }

    public Edge<E> getEdgeToVertex(int targetVertex) {
        for (Edge<E> edge : edges) {
            if (edge.getTargetVertexId() == targetVertex) {
                return edge;
            }
        }
        return null;
    }

    public Iterator<Edge<E>> getEdges() {
        return edges.iterator();
    }

    public int getEdgeCount() {
        return edges.size();
    }

    @Override
    public String toString() {
        return "'" + value + "' -> " + edges;
    }

}
