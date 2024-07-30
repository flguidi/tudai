package tp09.e08.condiciones;

import tp09.e08.Video;

public class CondicionAnio extends Condicion {
    // Atributos
    private int anioPublicacion;

    // Constructores
    public CondicionAnio(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Video video) {
        return video.getAnioPublicacion() == this.anioPublicacion;
    }
}
