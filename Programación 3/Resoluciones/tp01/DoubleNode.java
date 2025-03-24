package tp01;

public class DoubleNode<T> {

    private T info;
    private DoubleNode<T> prev, next;

    public DoubleNode() {
        this.info = null;
        this.prev = null;
        this.next = null;
    }

    public DoubleNode(T info, DoubleNode<T> prev, DoubleNode<T> next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public DoubleNode<T> getPrev() {
        return this.prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    public DoubleNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

}
