package tp09.e08.condiciones;

import tp09.e08.Video;

public class CondicionAutor extends Condicion {
    // Atributos
    private String nombreUsuario;

    // Constructores
    public CondicionAutor(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Video video) {
        return video.getUsuario().getNombre().equals(this.nombreUsuario);
    }
}
