package tp09.e08.condiciones;

import tp09.e08.Video;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion condicion;

    // Constructores
    public CondicionNot(Condicion condicion) {
        this.condicion = condicion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Video video) {
        return !condicion.esCumplidaPor(video);
    }
}
