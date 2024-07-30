package tp09.e04.condiciones;

import tp09.e04.Noticia;

public class CondicionPalabraClave extends Condicion {
    // Atributos
    private String palabraClave;

    // Constructores
    public CondicionPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.tienePalabraClave(palabraClave);
    }
}
