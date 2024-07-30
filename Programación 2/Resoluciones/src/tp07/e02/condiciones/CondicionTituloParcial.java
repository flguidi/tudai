package tp07.e02.condiciones;

import tp07.e02.Documento;

public class CondicionTituloParcial extends Condicion {
    // Atributos
    private String titulo;

    // Constructores
    public CondicionTituloParcial(String titulo) {
        this.titulo = titulo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Documento documento) {
        return documento.getTitulo().contains(titulo);
    }
}
