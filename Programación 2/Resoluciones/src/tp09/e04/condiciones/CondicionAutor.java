package tp09.e04.condiciones;

import tp09.e04.Noticia;

public class CondicionAutor extends Condicion {
    // Atributos
    private String autor;

    // Constructores
    public CondicionAutor(String autor) {
        this.autor = autor;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.getAutor().equals(autor);
    }
}
