package tp09.e04.condiciones;

import tp09.e04.Noticia;

public class CondicionTitulo extends Condicion {
    // Atributos
    private String titulo;

    // Constructores
    public CondicionTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.getTitulo().equals(titulo);
    }
}
