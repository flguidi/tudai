package tp01;

import java.util.Iterator;

public class SimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private SimpleNode<T> first;
    private SimpleNode<T> last;
    private int size;

    public SimpleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Inserta un nodo al principio de la lista.
     * Complejidad: O(1).
     *
     * @param info Información del nodo insertado.
     */
    public void insertFront(T info) {
        if (info == null) {
            return;
        }

        SimpleNode<T> newNode = new SimpleNode<>(info, null);
        if (isEmpty()) {
            last = newNode;
        }

        newNode.setNext(first);
        first = newNode;
        size++;
    }

    /**
     * Inserta un nodo al final de la lista.
     * Complejidad: O(1).
     *
     * @param info Información del nodo insertado.
     */
    public void insertEnd(T info) {
        if (info == null) {
            return;
        }

        SimpleNode<T> newNode = new SimpleNode<>(info, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }

        last = newNode;
        size++;
    }

    /**
     * Inserta al principio de la lista todos los elementos de otra lista pasada como argumento.
     * Complejidad: O(n).
     *
     * @param otherList Lista de la cual se copian los elementos.
     */
    public void insertListFront(SimpleLinkedList<T> otherList) {
        if (otherList == null) return;

        for (T element : otherList) {
            insertFront(element);
        }
    }

    /**
     * Inserta al final de la lista todos los elementos de otra lista pasada como argumento.
     * Complejidad: O(n).
     *
     * @param otherList Lista de la cual se copian los elementos.
     */
    public void insertListEnd(SimpleLinkedList<T> otherList) {
        if (otherList == null) return;

        for (T element : otherList) {
            insertEnd(element);
        }
    }

    /**
     * Elimina el primer nodo de la lista y retorna su contenido.
     *
     * @return Contenido del nodo eliminado.
     */
    public T extractFront() {
        if (isEmpty()) return null;

        T extractedInfo = first.getInfo();
        first = first.getNext();
        size--;

        return extractedInfo;
    }

    /**
     * Verifica si la lista está vacía, en función de si existe o no el primer nodo.
     * Complejidad: O(1).
     *
     * @return {@code true} si la lista está vacía, {@code false} de lo contrario.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Retorna la cantidad de nodos que tiene la lista.
     * Complejidad: O(1).
     *
     * @return Cantidad de nodos que contiene la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Retorna una cadena de texto con la información de cada nodo de la lista.
     * Complejidad: O(n).
     *
     * @return Cadena de texto con la información de cada nodo de la lista.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        SimpleNode<T> cursor = first;

        while (cursor != null) {
            sb.append(cursor.getInfo().toString());
            if (cursor.getNext() != null) sb.append(", ");
            cursor = cursor.getNext();
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Devuelve la información de un nodo especificado.
     * Complejidad: O(n).
     *
     * @param index Índice del nodo buscado.
     * @return El contenido del nodo buscado, o null si no existe el nodo.
     */
    public T get(int index) {
        SimpleNode<T> node = getNode(index);
        if (node != null) {
            return node.getInfo();
        }
        return null;
    }

    /**
     * Devuelve el nodo en la posición especificada. Complejidad: O(n)
     *
     * @param index Índice del nodo buscado
     * @return SimpleNode (si se encuentra el nodo) | null (si no lo encuentra)
     */
    private SimpleNode<T> getNode(int index) {
        if (index < 0 || index > size) return null;

        int i = 0;
        SimpleNode<T> cursor = first;
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

        SimpleNode<T> cursor = first;
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
     * Función de ordenamiento por selección.
     * Complejidad: O(n^2)
     *
     * @return Copia ordenada de la lista.
     */
    public SimpleLinkedList<T> selectionSort() {
        // Copia de lista
        SimpleLinkedList<T> sortedList = new SimpleLinkedList<>();
        sortedList.insertListFront(this);

        // Ordenamiento
        SimpleNode<T> cursor = sortedList.first;
        while (cursor != null) {
            SimpleNode<T> min = cursor;
            SimpleNode<T> next = cursor.getNext();

            while (next != null) {
                if (next.getInfo().compareTo(min.getInfo()) < 0)
                    min = next; // Se actualiza el valor mínimo
                next = next.getNext(); // Avanza el cursor secundario
            }

            // Intercambio de valores
            T tmp = cursor.getInfo();
            cursor.setInfo(min.getInfo());
            min.setInfo(tmp);

            cursor = cursor.getNext(); // Avanza el cursor primario
        }

        return sortedList;
    }

    /**
     * Devuelve un objeto Iterator para recorrer los elementos contenidos en la lista.
     * Recorrer la lista con un iterador presenta una mejora computacional, ya que puede
     * accederse a sus nodos secuencialmente sin necesidad de recorrer la lista una y otra vez.
     *
     * @return Iterador que permite recorrer los elementos de la lista.
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleLinkedListIterator(first);
    }

    /**
     * Clase interna que implementa la interfaz Iterator<T>, utilizada para iterar sobre los nodos de la lista.
     */
    private class SimpleLinkedListIterator implements Iterator<T> {
        private SimpleNode<T> cursor;

        public SimpleLinkedListIterator(SimpleNode<T> cursor) {
            this.cursor = cursor;
        }

        /**
         * Verifica si hay más nodos en la lista.
         *
         * @return {@code true} si existe un nodo siguiente, {@code false} de lo contrario.
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
