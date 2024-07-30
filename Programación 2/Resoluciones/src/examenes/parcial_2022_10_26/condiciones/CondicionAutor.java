package parcial_2022_10_26.condiciones;

import parcial_2022_10_26.Noticia;

public class CondicionAutor extends Condicion {
    // Atributos
    private String autorBuscado;

    // Constructores
    public CondicionAutor(String autorBuscado) {
        this.autorBuscado = autorBuscado;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.getAutor().equalsIgnoreCase(autorBuscado);
    }
}
