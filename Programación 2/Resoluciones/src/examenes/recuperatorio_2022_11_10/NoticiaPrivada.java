package recuperatorio_2022_11_10;

import recuperatorio_2022_11_10.condiciones.Condicion;

public class NoticiaPrivada extends Noticia {
    // Constructores
    public NoticiaPrivada(String categoria, String titulo, String autor, String contenido) {
        super(categoria, titulo, autor, contenido);
    }

    // Métodos
    @Override
    public ElementoPortal copiar(Condicion condicion) {
        return null;
    }
}
