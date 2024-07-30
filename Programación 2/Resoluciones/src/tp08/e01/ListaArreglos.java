package tp08.e01;

public class ListaArreglos implements SimpleList {
    // Atributos
    private static final int TAMANIO_INICIAL = 10;
    private Object[] elementos;
    private int cantElementos;

    // Constructores
    public ListaArreglos() {
        this.elementos = new Object[TAMANIO_INICIAL];
        this.cantElementos = 0;
    }

    // Métodos
    @Override
    public int size() {
        return cantElementos;
    }

    @Override
    public boolean isEmpty() {
        return cantElementos == 0;
    }

    @Override
    public boolean contains(Object elemento) {
        int i = 0;
        while (i < cantElementos) {
            if (elementos[i].equals(elemento))
                return true;
            i++;
        }
        return false;
    }

    @Override
    public void add(Object elemento) {
        if (cantElementos >= elementos.length)
            elementos = ampliarArreglo();
        elementos[cantElementos] = elemento;
        cantElementos++;
    }

    @Override
    public Object add(int indice, Object elemento) {
        if (indice >= 0 && indice <= this.size()) {
            if (cantElementos >= elementos.length)
                elementos = ampliarArreglo();
            desplazarADerecha(indice);
            elementos[indice] = elemento;
            cantElementos++;
            return elemento;
        }
        return null;
    }

    @Override
    public Object set(int indice, Object elemento) {
        if (indice >= 0 && indice < cantElementos) {
            Object reemplazado = elementos[indice];
            elementos[indice] = elemento; // Se reemplaza el elemento
            return reemplazado;
        }
        return null;
    }

    @Override
    public boolean remove(Object elemento) {
        int i = 0;
        while (i < cantElementos) {
            if (elementos[i].equals(elemento)) {
                if (cantElementos <= elementos.length / 2)
                    elementos = reducirArreglo();
                desplazarAIzquierda(i);
                elementos[cantElementos - 1] = null;
                cantElementos--;
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public Object remove(int indice) {
        if (indice >= 0 && indice < cantElementos) {
            if (cantElementos <= elementos.length / 2)
                elementos = reducirArreglo();
            Object eliminado = elementos[indice];
            desplazarAIzquierda(indice);
            elementos[cantElementos - 1] = null;
            cantElementos--;
            return eliminado;
        }
        return null;
    }

    @Override
    public void addAll(SimpleList otraLista) {
        for (int i = 0; i < otraLista.size(); i++) {
            add(otraLista.get(i));
        }
    }

    @Override
    public void clear() {
        elementos = new Object[TAMANIO_INICIAL];
        cantElementos = 0;
    }

    @Override
    public Object get(int indice) {
        if (indice >= 0 && indice < cantElementos)
            return elementos[indice];
        return null;
    }

    @Override
    public int indexOf(Object elemento) {
        int i = 0;
        while (i < cantElementos) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < cantElementos; i++) {
            str += elementos[i];
            if (i < this.size() - 1)
                str += ", ";
        }
        str += "]";
        return str;
    }

    public void depurar() {
        System.out.print("DEBUG -> ");
        for (int i = 0; i < elementos.length; i++)
            System.out.print(elementos[i] + " ");
        System.out.println();
    }

    private void desplazarADerecha(int index) {
        for (int i = elementos.length - 1; i > index; i--)
            elementos[i] = elementos[i - 1];
    }

    private void desplazarAIzquierda(int index) {
        for (int i = index; i < cantElementos - 1; i++)
            elementos[i] = elementos[i + 1];
    }

    private Object[] ampliarArreglo() {
        Object[] aux = new Object[elementos.length * 2];
        for (int i = 0; i < cantElementos; i++)
            aux[i] = elementos[i];
        return aux;
    }
    
    private Object[] reducirArreglo() {
        Object[] aux = new Object[elementos.length / 2];
        for (int i = 0; i < cantElementos; i++)
            aux[i] = elementos[i];
        return aux;
    }
}
