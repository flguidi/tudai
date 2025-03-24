package tp01;

import java.util.Iterator;

public class ListUtilities<T extends Comparable<T>> {

    /**
     * Devuelve una lista ordenada con la intersección entre dos listas desordenadas.
     *
     * @param list1 Primera lista
     * @param list2 Segunda lista
     * @return Lista ordenada con la intersección entre dos listas desordenadas.
     */
    public SimpleLinkedList<T> intersectionDisorderedLists(SimpleLinkedList<T> list1, SimpleLinkedList<T> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        SimpleLinkedList<T> output = new SimpleLinkedList<>();
        for (T element1 : list1) {
            for (T element2 : list2) {
                if (element1.equals(element2)) {
                    output.insertFront(element1);
                    break;
                }
            }
        }

        return output.selectionSort();
    }

    /**
     * Devuelve una lista ordenada con la intersección entre dos listas ordenadas.
     *
     * @param list1 Primera lista
     * @param list2 Segunda lista
     * @return Lista ordenada con la intersección entre dos listas ordenadas.
     */
    public SimpleLinkedList<T> intersectionOrderedLists(SimpleLinkedList<T> list1, SimpleLinkedList<T> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        SimpleLinkedList<T> output = new SimpleLinkedList<>();

        // Si alguna de las listas está vacía, se devuelve otra lista vacía
        if (list1.isEmpty() || list2.isEmpty()) {
            return output;
        }

        Iterator<T> itr1 = list1.iterator(); // Iterador de la lista 1
        Iterator<T> itr2 = list2.iterator(); // Iterador de la lista 2
        T info1 = itr1.next();
        T info2 = itr2.next();
        while (info1 != null && info2 != null) {
            int comparison = info1.compareTo(info2);
            if (comparison < 0) {
                // info1 < info2
                info1 = itr1.hasNext() ? itr1.next() : null;
            } else if (comparison > 0) {
                // info1 > info2
                info2 = itr2.hasNext() ? itr2.next() : null;
            } else {
                // info1 == info2
                output.insertEnd(info1);
                info1 = itr1.hasNext() ? itr1.next() : null;
                info2 = itr2.hasNext() ? itr2.next() : null;
            }
        }

        return output;
    }

    /**
     * Dadas dos listas, retorna una nueva lista con los elementos de la primera pero sin los elementos de la segunda.
     *
     * @param list1 Primera lista
     * @param list2 Segunda lista
     * @return Primera lista sin los elementos de la segunda.
     */
    public SimpleLinkedList<T> difference(SimpleLinkedList<T> list1, SimpleLinkedList<T> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        SimpleLinkedList<T> output = new SimpleLinkedList<>();
        boolean found;
        for (T element1 : list1) {
            found = false;
            for (T element2 : list2) {
                if (element1.equals(element2)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                output.insertFront(element1);
        }

        return output;
    }

}
