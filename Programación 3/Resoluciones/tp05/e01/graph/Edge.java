package tp05.e01.graph;

public class Edge<E> {

    private Integer sourceVertexId;
    private Integer targetVertexId;
    private E label;

    public Edge(Integer sourceVertexId, Integer targetVertexId) {
        this.sourceVertexId = sourceVertexId;
        this.targetVertexId = targetVertexId;
    }

    public Edge(Integer sourceVertexId, Integer targetVertexId, E label) {
        this(sourceVertexId, targetVertexId);
        this.label = label;
    }

    public Integer getSourceVertexId() {
        return sourceVertexId;
    }

    public void setSourceVertexId(Integer sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }

    public Integer getTargetVertexId() {
        return targetVertexId;
    }

    public void setTargetVertexId(Integer targetVertexId) {
        this.targetVertexId = targetVertexId;
    }

    public E getLabel() {
        return label;
    }

    public void setLabel(E label) {
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(" + sourceVertexId + "->" + targetVertexId);
        if (label != null) {
            sb.append(", ").append(label);
        }
        sb.append(")");

        return sb.toString();
    }

}
