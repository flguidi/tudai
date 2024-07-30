package recuperatorio_2022_11_10.condiciones;

import recuperatorio_2022_11_10.Noticia;

public class CondicionTitulo extends Condicion {
    // Atributos
    private String tituloBuscado;

    // Constructores
    public CondicionTitulo(String tituloBuscado) {
        this.tituloBuscado = tituloBuscado;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.getTitulo().contains(tituloBuscado);
    }
}
