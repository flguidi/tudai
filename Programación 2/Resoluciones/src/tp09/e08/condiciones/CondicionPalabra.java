package tp09.e08.condiciones;

import tp09.e08.Video;

public class CondicionPalabra extends Condicion {
    // Atributos
    private String palabra;

    // Constructores
    public CondicionPalabra(String palabra) {
        this.palabra = palabra;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Video video) {
        return video.contienePalabra(this.palabra);
    }
}
