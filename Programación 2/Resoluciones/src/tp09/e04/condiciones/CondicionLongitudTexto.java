package tp09.e04.condiciones;

import tp09.e04.Noticia;

public class CondicionLongitudTexto extends Condicion {
    // Atributos
    private int longitudMinima;

    // Constructores
    public CondicionLongitudTexto(int longitudMinima) {
        this.longitudMinima = longitudMinima;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.getTexto().length() > longitudMinima;
    }
}
