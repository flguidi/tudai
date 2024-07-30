package tp09.e08.condiciones;

import tp09.e08.Video;

public class CondicionMeGusta extends Condicion {
    // Atributos
    private int cantidadMinima;

    // Constructores
    public CondicionMeGusta(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Video video) {
        return video.getCantMeGusta() > this.cantidadMinima;
    }
}
