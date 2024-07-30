package tp07.e02.condiciones;

import tp07.e02.Documento;

public class CondicionTituloIgual extends Condicion {
    // Atributos
    private String titulo;

    // Constructores
    public CondicionTituloIgual(String titulo) {
        this.titulo = titulo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Documento documento) {
        return documento.getTitulo().equals(titulo);
    }
}
