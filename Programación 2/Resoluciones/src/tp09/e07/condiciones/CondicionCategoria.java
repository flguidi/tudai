package tp09.e07.condiciones;

import tp09.e07.ElementoBazar;

public class CondicionCategoria extends Condicion {
    // Atributos
    private String categoria;

    // Constructores
    public CondicionCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoBazar elemento) {
        return elemento.tieneCategoria(this.categoria);
    }
}
