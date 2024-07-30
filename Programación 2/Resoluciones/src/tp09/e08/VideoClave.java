package tp09.e08;

public class VideoClave extends Video {
    // Constructores
    public VideoClave(String titulo, Usuario usuario, int duracion, int cantVisualizaciones,
                      int cantMeGusta, int cantNoMeGusta, int anioPublicacion) {
        super(titulo, usuario, duracion, cantVisualizaciones, cantMeGusta, cantNoMeGusta, anioPublicacion);
    }

    // Métodos
    @Override
    public boolean contienePalabra(String palabra) {
        return true;
    }
}
