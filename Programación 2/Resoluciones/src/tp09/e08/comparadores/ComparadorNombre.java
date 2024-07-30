package tp09.e08.comparadores;

import tp09.e08.Video;
import java.util.Comparator;

public class ComparadorNombre implements Comparator<Video> {
    @Override
    public int compare(Video v1, Video v2) {
        return v1.getUsuario().getNombre().compareTo(v2.getUsuario().getNombre());
    }
}
