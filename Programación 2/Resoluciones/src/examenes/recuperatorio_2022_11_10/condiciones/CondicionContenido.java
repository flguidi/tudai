package recuperatorio_2022_11_10.condiciones;

import recuperatorio_2022_11_10.Noticia;

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
