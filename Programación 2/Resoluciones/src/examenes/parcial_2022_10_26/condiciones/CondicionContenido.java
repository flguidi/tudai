package parcial_2022_10_26.condiciones;

import parcial_2022_10_26.Noticia;

public class CondicionContenido extends Condicion {
    // Atributos
    private String contenidoBuscado;

    // Constructores
    public CondicionContenido(String contenidoBuscado) {
        this.contenidoBuscado = contenidoBuscado;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.getContenido().contains(contenidoBuscado);
    }
}
