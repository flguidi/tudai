package tp07.e02.condiciones;

import tp07.e02.Documento;

public class CondicionAutor extends Condicion {
    // Atributos
    private String autor;

    // Constructores
    public CondicionAutor(String autor) {
        this.autor = autor;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Documento documento) {
        return documento.tieneAutor(autor);
    }
}
