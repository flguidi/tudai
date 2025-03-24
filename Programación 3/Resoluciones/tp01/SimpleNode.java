package tp01;

public class SimpleNode<T> {

    private T info;
    private SimpleNode<T> next;

    public SimpleNode() {
        this.info = null;
        this.next = null;
    }

    public SimpleNode(T info, SimpleNode<T> next) {
        this.info = info;
        this.next = next;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public SimpleNode<T> getNext() {
        return this.next;
    }

    public void setNext(SimpleNode<T> next) {
        this.next = next;
    }

}
