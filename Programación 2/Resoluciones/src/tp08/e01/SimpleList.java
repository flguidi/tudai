package tp08.e01;

public interface SimpleList {
    /**
     * Retorna la cantidad de elementos de la lista.
     */
    int size();

    /**
     * Retorna true si la lista no contiene elementos y false si contiene al menos un elemento.
     */
    boolean isEmpty();

    /**
     * Retorna true si la lista contiene al objeto o pasado como parámetro.
     */
    boolean contains(Object element);

    /**
     * Agrega un objeto dado al final de la lista.
     */
    void add(Object element);

    /**
     * Agrega el objeto element en la posición pasada como parámetro. Se realizan los corrimientos necesarios
     * con los elementos posteriores a dicha posición. Si la posición index no existe retorna null, caso
     * contrario retorna el mismo objeto agregado.
     */
    Object add(int index, Object element);

    /**
     * Se sobreescribe el elemento existente en la posición dada. El elemento que anteriormente ocupaba la
     * posición index es retornado al usuario. Si la posición index no existe, retorna null.
     */
    Object set (int index, Object element);

    /**
     * Elimina la primera ocurrencia del objeto element pasado como parámetro. Si el objeto no se encontró,
     * retorna false. Caso contrario, retorna true.
     */
    boolean remove(Object element);

    /**
     * Elimina el objeto que ocupa la posición index pasada como parámetro lo retorna al usuario. Si no existe,
     * retorna null.
     */
    Object remove(int index);

    /**
     * Agrega todos los elementos de la lista otherList pasada como parámetro al final de la lista que recibe
     * el mensaje.
     */
    void addAll(SimpleList otherList);

    /**
     * Elimina todos los elementos de la lista.
     */
    void clear();

    /**
     * Retorna el objeto almacenado en la posición index. Si no existe la posición, retorna null.
     */
    Object get(int index);

    /**
     * Retorna la posición en la que se encuentra el objeto element pasado como parámetro. Si el objeto no existe
     * en la lista, retorna -1.
     */
    int indexOf(Object element);
}
