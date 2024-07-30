package tp09.e08.comparadores;

import tp09.e08.Video;
import java.util.Comparator;

public class ComparadorCompuesto implements Comparator<Video> {
    // Atributos
    private Comparator<Video> comparador1;
    private Comparator<Video> comparador2;

    // Constructores
    public ComparadorCompuesto(Comparator<Video> comparador1, Comparator<Video> comparador2) {
        this.comparador1 = comparador1;
        this.comparador2 = comparador2;
    }

    // Métodos
    @Override
    public int compare(Video v1, Video v2) {
        int comparacion = comparador1.compare(v1, v2);
        if (comparacion != 0)
            return comparacion;
        else
            return comparador2.compare(v1, v2);
    }
}
