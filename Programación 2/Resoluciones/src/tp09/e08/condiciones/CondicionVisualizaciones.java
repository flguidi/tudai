package tp09.e08.condiciones;

import tp09.e08.Video;

public class CondicionVisualizaciones extends Condicion {
    // Atributos
    private int cantidadMinima;

    // Constructores
    public CondicionVisualizaciones(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Video video) {
        return video.getCantVisualizaciones() > cantidadMinima;
    }
}
