package recuperatorio_2022_11_10.condiciones;

import recuperatorio_2022_11_10.Noticia;

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
        return noticia.getAutor().equals(autorBuscado);
    }
}
