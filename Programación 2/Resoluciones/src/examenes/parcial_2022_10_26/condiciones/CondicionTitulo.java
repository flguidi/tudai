package parcial_2022_10_26.condiciones;

import parcial_2022_10_26.Noticia;

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
