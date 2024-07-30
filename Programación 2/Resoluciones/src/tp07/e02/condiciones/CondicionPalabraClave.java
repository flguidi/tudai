package tp07.e02.condiciones;

import tp07.e02.Documento;

public class CondicionPalabraClave extends Condicion {
    // Atributos
    private String palabraClave;

    // Constructores
    public CondicionPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Documento documento) {
        return documento.tienePalabraClave(palabraClave);
    }
}
