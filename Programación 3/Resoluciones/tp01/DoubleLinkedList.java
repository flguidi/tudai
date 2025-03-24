package tp01;

import java.util.Iterator;

public class DoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private DoubleNode<T> first;
    private DoubleNode<T> last;
    private int size;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Inserta un nodo al principio de la lista.
     * Complejidad: O(1).
     *
     * @param info Información del nodo insertado.
     */
    public void insertFront(T info) {
        if (info == null) return;

        DoubleNode<T> newNode = new DoubleNode<>(info, null, null);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrev(newNode);
            first = newNode;
        }

        size++;
    }

    /**
     * Inserta un nodo al final de la lista.
     * Complejidad: O(1).
     *
     * @param info Información del nodo insertado.
     */
    public void insertEnd(T info) {
        if (info == null) return;

        DoubleNode<T> newNode = new DoubleNode<T>(info, null, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
        }

        last = newNode;
        size++;
    }

    /**
     * Inserta al principio de la lista todos los elementos de otra lista dada.
     * Complejidad: O(n).
     *
     * @param otherList Lista de la cual se copian los elementos.
     */
    public void insertListFront(DoubleLinkedList<T> otherList) {
        if (otherList == null) return;
        for (T element : otherList) {
            insertFront(element);
        }
    }

    /**
     * Elimina el primer nodo de la lista y retorna su contenido.
     * Complejidad: O(1).
     *
     * @return Contenido del nodo eliminado.
     */
    public T extractFront() {
        if (isEmpty()) return null;

        T extractedInfo = first.getInfo();
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrev(null);
        }

        size--;
        return extractedInfo;
    }

    /**
     * Elimina el último nodo de la lista y retorna su contenido.
     * Complejidad: O(1).
     *
     * @return Información del nodo eliminado, o null si no se encontró el nodo.
     */
    public T extractEnd() {
        if (isEmpty()) return null;

        T removedInfo = last.getInfo();
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.getPrev();
            last.setNext(null);
        }

        size--;
        return removedInfo;
    }

    /**
     * Verifica si la lista está vacía, en función de si existe o no el primer nodo.
     * Complejidad: O(1).
     *
     * @return {@code true} si está vacía, {@code false} de lo contrario.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Retorna la cantidad de nodos que tiene la lista.
     * Complejidad: O(1).
     *
     * @return Cantidad de nodos de la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Retorna una cadena de texto con la información de cada nodo de la lista.
     * Complejidad: O(n).
     *
     * @return Cadena de texto con la información de cada nodo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        DoubleNode<T> cursor = first;

        while (cursor != null) {
            sb.append(cursor.getInfo().toString());
            if (cursor.getNext() != null) {
                sb.append(", ");
            }
            cursor = cursor.getNext();
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Devuelve la información de un nodo específico.
     * Complejidad: O(n).
     *
     * @param index Índice del nodo buscado.
     * @return Información del nodo buscado, o null si no existe el nodo.
     */
    public T get(int index) {
        DoubleNode<T> node = getNode(index);
        if (node != null) {
            return node.getInfo();
        }
        return null;
    }

    /**
     * Devuelve el nodo en la posición especificada.
     * Complejidad: O(n).
     *
     * @param index Índice del nodo buscado.
     * @return El nodo si se encuentra, o null en caso contrario.
     */
    private DoubleNode<T> getNode(int index) {
        if (index < 0 || index > size) return null;

        int i = 0;
        DoubleNode<T> cursor = first;
        while (i < index) {
            cursor = cursor.getNext();
            i++;
        }

        return cursor;
    }

    /**
     * Retorna el índice del primer nodo cuya información coincide con la información pasada como argumento.
     * Complejidad: O(n).
     *
     * @param info Información buscada.
     * @return Número entero positivo si se encuentra el nodo, -1 de lo contrario.
     */
    public int indexOf(T info) {
        if (info == null) return -1;

        DoubleNode<T> cursor = first;
        int index = 0;
        while (cursor != null) {
            if (cursor.getInfo().equals(info)) {
                return index;
            }
            index++;
            cursor = cursor.getNext();
        }

        return -1;
    }

    /**
     * Devuelve un objeto Iterator para recorrer los elementos contenidos en la lista.
     * Recorrer la lista con un iterador presenta una mejora computacional, ya que puede
     * accederse a sus nodos secuencialmente sin necesidad de recorrer la lista una y otra vez.
     *
     * @return Iterador que permite recorrer los elementos de la lista.
     */
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator(first);
    }

    /**
     * Clase interna que implementa la interfaz Iterator<T>, utilizada para iterar sobre los nodos de la lista.
     */
    public class DoubleLinkedListIterator implements Iterator<T> {
        private DoubleNode<T> cursor;

        public DoubleLinkedListIterator(DoubleNode<T> cursor) {
            this.cursor = cursor;
        }

        /**
         * Verifica si hay más nodos en la lista.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        /**
         * Devuelve la información del puntero actual y avanza al siguiente nodo de la lista.
         *
         * @return Información del nodo apuntado por el puntero.
         */
        @Override
        public T next() {
            T info = cursor.getInfo();
            cursor = cursor.getNext();
            return info;
        }
    }

}
