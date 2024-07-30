package tp09.e08.condiciones;

import tp09.e08.Video;

public class CondicionOr extends Condicion {
    // Atributos
    private Condicion condicion1;
    private Condicion condicion2;

    // Constructores
    public CondicionOr(Condicion condicion1, Condicion condicion2) {
        this.condicion1 = condicion1;
        this.condicion2 = condicion2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Video video) {
        return condicion1.esCumplidaPor(video) || condicion2.esCumplidaPor(video);
    }
}
