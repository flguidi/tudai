package tp07.e02.condiciones;

import tp07.e02.Documento;

public class CondicionContenido extends Condicion {
    // Atributos
    private String contenido;

    // Constructores
    public CondicionContenido(String contenido) {
        this.contenido = contenido;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Documento documento) {
        return documento.getContenido().contains(contenido);
    }
}
